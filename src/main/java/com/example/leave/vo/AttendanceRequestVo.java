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
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<AttendanceVo> getAttendanceBaseData() {
		return attendanceBaseData;
	}
	public void setAttendanceBaseData(List<AttendanceVo> attendanceBaseData) {
		this.attendanceBaseData = attendanceBaseData;
	}
	
	
}
