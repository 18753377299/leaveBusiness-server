package com.example.leave.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class LeaveMain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String jobNum;
	private String employeeName;
	private String teamCode;
	private String teamName;
	private String projectCode;
	private String projectName;
	private String leaveType;
	private String detailDesc;
	private Date startTime;
	private Date endTime;
	private Integer sumDay;
	private String flag;
	private Date insertTimeForHis;
	private Date operateTimeForHis;
	
}
