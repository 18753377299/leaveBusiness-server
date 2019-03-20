package com.example.leave.dao;

import java.util.List;

import com.example.leave.po.LeaveSpecdate;

public interface LeaveSpecialDateDao {
	
	public List<LeaveSpecdate> querySpecialDateByTime(String yearMonth);
}
