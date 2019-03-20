package com.example.leave.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.DateUtil;
import com.example.common.LeaveResponseVo;
import com.example.common.ResultResponse;
import com.example.leave.dao.LeaveBasicDao;
import com.example.leave.dao.LeaveMainDao;
import com.example.leave.dao.LeaveSpecialDateDao;
import com.example.leave.po.LeaveBasic;
import com.example.leave.po.LeaveMain;
import com.example.leave.po.LeaveSpecdate;
import com.example.leave.vo.AttendanceRequestVo;
import com.example.leave.vo.AttendanceVo;


@Service
public class LeaveService {
	
	@Autowired
	LeaveBasicDao leaveBasicDao;
	
	@Autowired
	LeaveMainDao leaveMainDao;
	
	@Autowired
	LeaveSpecialDateDao leaveSpecialDateDao;
	/**
	 * 根据考勤记录来判断人员倒休情况和矿工情况o
	 * ---调整请假倒休信息
	 * 20190123
	 * */
	public LeaveResponseVo adjustLeaveRetreatInfo(AttendanceRequestVo attendanceRequestVo) {
		LeaveResponseVo leaveResponseVo=new LeaveResponseVo();
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		//获取考勤信息的年月，格式为2019-01
		String yearMonth = attendanceRequestVo.getYearMonth();
		
		//把考勤信息整理成一个map集合
		Map<String, List<AttendanceVo>> mapAttendance = this.handleAttendanceInfo(attendanceRequestVo.getAttendanceBaseData());
		// 查询出导入考勤信息的该月中一共有多少天
		int day = this.getMaxDays(yearMonth);
		//根据日期查出所有的特殊节假日
		Map<String, String> specialDateMap = this.quereySpecialDate(yearMonth);
		//根据键值即工号进行遍历
		for(String userCode: mapAttendance.keySet()) {
			//将签到日期和考勤数据组织成map形式
			Map<String, List<AttendanceVo>> mapAttendanceDate = this.handleAttendanceDate(mapAttendance.get(userCode));
			//看是否离职
			//看是否已经导入考勤
			for(int i=1;i<day;i++) {
				//获取当前的时间值
				String dayCurrent = yearMonth+"-"+(i<10?"0"+i:+i);
				//看当前值是否有考勤
				if(mapAttendanceDate.get(dayCurrent)!=null) {
					// 如果有考勤记录，看考勤记录是否是半天
					
					
				}else {
					//如果没有考勤记录，则看是否是应该上班，若是则 
					
					
				}
				
			}
			
		}
		
		
		return null;
	}
	//将考勤日期组织成map形式
	public Map<String,List<AttendanceVo>> handleAttendanceDate(List<AttendanceVo> attendanceVoList){
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, List<AttendanceVo>> mapAttendanceDate =new HashMap<String, List<AttendanceVo>>();
		if(attendanceVoList!=null&&attendanceVoList.size()>0) {
			for(AttendanceVo attendanceVo:attendanceVoList) {
				//考勤中的签到日期
				String attendanceDate = sdFormat.format(attendanceVo.getSignDate());
				if(mapAttendanceDate.containsKey(attendanceDate)) {
					mapAttendanceDate.get(attendanceDate).add(attendanceVo);
				}else {
					List<AttendanceVo> attendanceVos = new ArrayList<AttendanceVo>();
					attendanceVos.add(attendanceVo);
					mapAttendanceDate.put(attendanceDate, attendanceVos);
				}
			}
		}		
		return mapAttendanceDate;
	}
	
	//根据日期查出所有的特殊节假日
	public Map<String, String> quereySpecialDate(String  yearMonth){
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> map =new HashMap<String, String>();
		//根据模糊匹配查询出该年该月的所有特殊节假日的条数
		List<LeaveSpecdate>  leaveSpecdateList = leaveSpecialDateDao.querySpecialDateByTime(yearMonth);
		if(leaveSpecdateList!=null&&leaveSpecdateList.size()>0) {
			for(LeaveSpecdate leaveSpecdate: leaveSpecdateList) {
				String date = sdFormat.format(leaveSpecdate.getDate());
				map.put(date, leaveSpecdate.getDateType());
			}
		}
		return map;
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
	
	/**
	 * @Author: liqiankun 
	 * @Date 20190310
	 * @description  请假录入
	 * 
	 * */
	public  ResultResponse saveLeaveBasic(LeaveMain leaveMain) {
		ResultResponse resultResponse =new ResultResponse();
		String jobNum = leaveMain.getJobNum();
		// 看该月考勤信息是否已经导入，若已经导入则不能进行录入该月请假信息
		if(StringUtils.isNotBlank(jobNum)) {
			
			// 通过唯一的员工工号进行查询是否能够进行该种类型的请假
			LeaveBasic leaveBasicVo = new LeaveBasic();
			leaveBasicVo.setJobNum(leaveMain.getJobNum());
			LeaveBasic leaveBasic = leaveBasicDao.selectLeaveBasicInfo(leaveBasicVo);
			// 请假的总天数
			Integer sumDay =  leaveMain.getSumDay();
			if(sumDay>0) {
				// 年假
				if("C".equals(leaveMain.getLeaveType())) {
					//剩余年假总天数
					Integer laveDay = leaveBasic.getAnnualDay()-leaveBasic.getUsedAnnualDay();
					if(laveDay.compareTo(sumDay)<0) {
						resultResponse.setFlag("2");
						resultResponse.setMessage("剩余年假天数不足，请选择其他请假方式！");
					}else {
						
					}
				}
				// 判断该时期是否已经录入，录入的不能进行重复录入
				
				
				if("2".equals(resultResponse.getFlag())) {
				}else {
					//请假基本信息的更新
					
					// 进行请假信息的插入
					leaveMainDao.insertLeaveMainInfo(leaveMain);
				}
				
			}else {
				resultResponse.setMessage("没有进行请假，无需录入！");
				resultResponse.setFlag("2");
			}
		}
		
		
		return resultResponse;
	}
	/**
	 * @Author: liqiankun 
	 * @Date 20190311
	 * @description  请假查询
	 * 
	 * */
//	public ResultResponse selectLeaveBasic(leaveBasic);
	
}
