package com.example.leave.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.leave.po.Dept;

@Mapper
public interface DeptDao{

	public Dept findById(Long id);
	
}
