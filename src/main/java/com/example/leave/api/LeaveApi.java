package com.example.leave.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.LeaveResponseVo;
import com.example.common.ResultResponse;
import com.example.leave.po.Dept;
import com.example.leave.po.LeaveBasic;
import com.example.leave.po.LeaveMain;
import com.example.leave.service.DeptServiceImpl;
import com.example.leave.service.LeaveService;
import com.example.leave.vo.AttendanceRequestVo;

//使用@RestController 之后可以不用再每一个方法上写@ResponseBody注解来获取返回信息
@RestController
@RequestMapping(value="/leave-api")
public class LeaveApi {
	
	@Autowired
	private DeptServiceImpl service;
	/**请假service*/
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
	
	/**
	 * 请假录入
	 * 录入的时候首先判断 是否有该请假天数，没有则不允许请假
	 * */
	@RequestMapping(value="/saveLeaveBasic",method= {RequestMethod.POST,RequestMethod.GET})
	public ResultResponse  saveLeaveBasic(@RequestBody LeaveMain leaveMain) {
		ResultResponse resultResponse =new ResultResponse();
		
		resultResponse = leaveService.saveLeaveBasic(leaveMain);
		
		return resultResponse;
	}
	
	/**
	 * @Author: liqiankun 
	 * @Date 20190310
	 * @description   请假查询
	 * 
	 * */
	@RequestMapping(value="/selectLeaveBasic",method= {RequestMethod.POST,RequestMethod.GET})
	public ResultResponse  selectLeaveBasic(@RequestBody LeaveBasic leaveBasic) {
		ResultResponse resultResponse =new ResultResponse();
		
//		resultResponse = leaveService.selectLeaveBasic(leaveBasic);
		
		return resultResponse;
	}
	
	/**
	 * @Author: liqiankun 
	 * @Date 20190310
	 * @description   请假删除(单个删除/ 批量删除)
	 * 
	 * */
	@RequestMapping(value="/deleteLeaveBasic",method= {RequestMethod.POST,RequestMethod.GET})
	public ResultResponse  deleteLeaveBasic(@RequestBody LeaveBasic leaveBasic) {
		ResultResponse resultResponse =new ResultResponse();
		
//		resultResponse = leaveService.deleteLeaveBasic(leaveBasic);
		
		return resultResponse;
	}

}
