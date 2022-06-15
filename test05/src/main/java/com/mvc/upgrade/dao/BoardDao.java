package com.mvc.upgrade.dao;

import java.util.List;

import com.mvc.upgrade.dto.BoardDto;

public interface BoardDao {
	
	//이건 우리가 지칭 정해주는거
	String NAMESPACE = "myboard.";
	
	public List<BoardDto>selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
}
