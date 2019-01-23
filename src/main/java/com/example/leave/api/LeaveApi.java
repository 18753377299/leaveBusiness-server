package com.example.leave.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.LeaveResponseVo;
import com.example.leave.po.Dept;
import com.example.leave.po.LeaveBasic;
import com.example.leave.service.DeptServiceImpl;
import com.example.leave.service.LeaveService;
import com.example.leave.vo.AttendanceRequestVo;

@RestController
@RequestMapping(value="/leave-api")
public class LeaveApi {
	
	@Autowired
	private DeptServiceImpl service;
	
	@Autowired
	LeaveService leaveService;
	
	@Value("${spring.application.name}")
	private String dbUrl;
	
	@RequestMapping(value="/getLeaveBasic/get/{id}",method= {RequestMethod.GET,RequestMethod.POST})
	public Dept getLeaveBasic(@PathVariable(value="id") Integer id) {
		System.out.println("==================getin:"+dbUrl);
		Long idLong =1L;
		Dept dept = service.get(idLong);
		
		return dept;
	}
	@RequestMapping(value="/get/{id}",method= {RequestMethod.GET,RequestMethod.POST})
	public LeaveBasic getLeaveBasicInfo(@PathVariable(value="id") Integer id) {
		System.out.println("==================getinBasic");
		
		LeaveBasic leaveBasic = service.getLeaveBasic(id);
		
		return leaveBasic;
	}
	/**
	 * 根据考勤记录来判断人员倒休情况和矿工情况
	 * ---调整请假倒休信息
	 * 20190123
	 * */
	@RequestMapping(value="/adjustLeaveRetreatInfo")
	public LeaveResponseVo adjustLeaveRetreatInfo(@RequestBody AttendanceRequestVo attendanceRequestVo) {
		LeaveResponseVo leaveResponseVo = new LeaveResponseVo();
		leaveResponseVo=leaveService.adjustLeaveRetreatInfo(attendanceRequestVo);
		return null;
	}

}
