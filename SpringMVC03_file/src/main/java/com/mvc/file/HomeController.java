package com.mvc.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.file.validate.FileValidator;
import com.mvc.file.validate.UploadFile;


@Controller
public class HomeController {
	/*
	 * upload.jsp  --------- > controller  --------------> re 
	 * multiparty,string        파일 			outputStream
	 * 
	 * 
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping(value="/form.do")
	public String getUploadForm() {
		return "uploadForm";
	}
	
	//문제가 나면 bindingresult 객체에 담아놓고 사용한다
	@RequestMapping("/upload.do")
	public String fileUpload(HttpServletRequest request,Model model,UploadFile uploadfile,BindingResult result) {
		
		System.out.println(uploadfile.getDesc()+"~~~~");
		System.out.println(uploadfile.getFile().getSize());
		//유효성 검사. 파일의 크기가 0인지
		fileValidator.validate(uploadfile, result);
		if(result.hasErrors()) {
			return "uploadForm";
		}
		
		//서버에 저장
		//datastream 자바에서 외부로 파일을 보내겠다
		MultipartFile file = uploadfile.getFile();
		String filename = file.getOriginalFilename(); //업로드한 파일의 실제 이름
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadfile.getDesc());
		
		//외부파일이 자바로 들어가겠다
		InputStream inputStream = null;
		//자바에서 외부파일로
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			
			String path = WebUtils.getRealPath(request.getSession().getServletContext(),"/storage");
			
			System.out.println("업로드 될 실제 경로: " + path);
			
			File storage = new File(path);
			if(!storage.exists()) { //존재여부 확인
				storage.mkdirs(); //디젝토리 만들기
			}
			
			File newfile = new File(path+"/"+filename); //비어있는 파일 경로
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newfile); //outputStream byte단위
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];  //사이즈를 읽는다
			
			while( (read=inputStream.read(b)) != -1) {
				outputStream.write(b,0,read);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj",fileobj);
		return "uploadFile";
	}
}
