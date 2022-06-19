package com.mvc.file.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//유효성 검사
@Service
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//형변환
		UploadFile file = (UploadFile)target;
		
		//파일이 없으면 에러문
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "errorCode","Please select a file");
		}
	}

}
