package com.example.leave.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * 通过ins-framework-mybatis工具自动生成，表admin_specdate的VO对象<br/>
 * 对应表名：admin_specdate
 */

@Data
public class LeaveSpecdate implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 对应字段：id */
	private Integer id;
	/** 对应字段：dateType */
	private String dateType;
	/** 对应字段：date */
	private Date date;
	/** 对应字段：insertTimeForHis */
	private Date insertTimeForHis;
	/** 对应字段：operateTimeForHis */
	private Date operateTimeForHis;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getInsertTimeForHis() {
		return insertTimeForHis;
	}
	public void setInsertTimeForHis(Date insertTimeForHis) {
		this.insertTimeForHis = insertTimeForHis;
	}
	public Date getOperateTimeForHis() {
		return operateTimeForHis;
	}
	public void setOperateTimeForHis(Date operateTimeForHis) {
		this.operateTimeForHis = operateTimeForHis;
	}
	
	

}
