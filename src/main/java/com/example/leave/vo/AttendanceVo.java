package com.example.leave.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
*
* 通过ins-framework-mybatis工具自动生成，表admin_specdate的VO对象<br/>
* 考勤信息表
*
*/
@Data
public class AttendanceVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 对应字段：id */
	private String id;
	/** 对应字段：dateType */
	private String userCode;
	private String username;
	private String department;
	private String projectCode;
	private String projectName;
	/** 对应字段：date */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date signDate;
	/** 对应字段：insertTimeForHis */
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private String signTimeStart;
	/** 对应字段：operateTimeForHis */
	private String signTimeEnd;

}
