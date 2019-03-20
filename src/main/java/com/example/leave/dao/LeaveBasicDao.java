package com.example.leave.dao;

import com.example.leave.po.LeaveBasic;

public interface LeaveBasicDao {
	
	public LeaveBasic getLeaveBasicById(Integer id);
	
	// 查询请假基础表信息
	public LeaveBasic selectLeaveBasicInfo(LeaveBasic  leaveBasic);
	
}
