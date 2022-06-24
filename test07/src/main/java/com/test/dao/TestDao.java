package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.test.dto.TestDto;

@Mapper
public interface TestDao {
	
	@Select("SELECT * FROM TEST_DB")
	 List<TestDto> select();
	
	@Insert("INSERT INTO VALUES(#{name},#{age},#{addr}")
	 int insert(TestDto dto);
}
