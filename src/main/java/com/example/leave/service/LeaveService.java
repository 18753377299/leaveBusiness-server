package com.example.leave.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.DateUtil;
import com.example.common.LeaveResponseVo;
import com.example.leave.dao.LeaveBasicDao;
import com.example.leave.vo.AttendanceRequestVo;
import com.example.leave.vo.AttendanceVo;

@Service
public class LeaveService {
	
	@Autowired
	LeaveBasicDao leaveBasicDao;
	
	/**
	 * 根据考勤记录来判断人员倒休情况和矿工情况
	 * ---调整请假倒休信息
	 * 20190123
	 * */
	public LeaveResponseVo adjustLeaveRetreatInfo(AttendanceRequestVo attendanceRequestVo) {
		LeaveResponseVo leaveResponseVo=new LeaveResponseVo();
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		//获取考勤信息的年月，格式为2019-01
		String yearMonth = attendanceRequestVo.getYearMonth();
		
		//把考勤信息整理成一个map集合
		Map<String, List<AttendanceVo>> mapAttendance = this.handleAttendanceInfo(attendanceRequestVo.getAttendanceBaseData());
		// 查询出导入考勤信息的该月中一共有多少天
		int day = this.getMaxDays(yearMonth);
		//根据键值即工号进行遍历
		for(String userCode: mapAttendance.keySet()) {
			
		}
		
		
		return null;
	}
	//通过当前日期获取该月最大的天数
	public int getMaxDays(String yearMonth) {
		int day = 0;
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdFormat.parse(yearMonth));
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			day = DateUtil.getDaysByYearMonth(year, month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}
	
	/**
	 * 把考勤信息整理成一个map集合中
	 * */
	public Map<String,List<AttendanceVo>> handleAttendanceInfo(List<AttendanceVo> attendanceVoList){
		
		Map<String, List<AttendanceVo>> mapAttendance =new HashMap<String, List<AttendanceVo>>();
		
		if(attendanceVoList!=null&&attendanceVoList.size()>0) {
			for(AttendanceVo attendanceVo:attendanceVoList) {
				if(mapAttendance.containsKey(attendanceVo.getUserCode())) {
					mapAttendance.get(attendanceVo.getUserCode()).add(attendanceVo);
				}else {
					List<AttendanceVo> attendanceVos = new ArrayList<AttendanceVo>();
					attendanceVos.add(attendanceVo);
					mapAttendance.put(attendanceVo.getUserCode(), attendanceVos);
				}
			}
		}		
		
		return mapAttendance;
	}
	
}
