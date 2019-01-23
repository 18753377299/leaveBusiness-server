package com.example.leave.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.leave.po.LeaveBasic;

@Mapper
public interface LeaveBasicDao {
	
	public LeaveBasic getLeaveBasicById(Integer id);
	
}
