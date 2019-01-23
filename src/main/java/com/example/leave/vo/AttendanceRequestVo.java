package com.example.leave.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AttendanceRequestVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String yearMonth;
	private String count;
	private List<AttendanceVo> attendanceBaseData;
}
