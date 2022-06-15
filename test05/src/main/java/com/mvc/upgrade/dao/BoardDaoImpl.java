package com.mvc.upgrade.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	//Autowired를 쓰는 이유는 객체이름이 같으므로 자동으로 할당
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlSession.selectList("myboard.selectList");
		} catch (Exception e) {
			System.out.println("[error]:select list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne",myno);
		} catch (Exception e) {
			System.out.println("[error]:select one");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete",myno);
		} catch (Exception e) {
			System.out.println("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

}
