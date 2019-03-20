package com.example.riskinfo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.ResponseResult;
import com.example.riskinfo.service.RiskInfoService;

@RestController
@RequestMapping(value="/riskinfo-api")
public class RiskInfoApi {
	
	@Autowired
	RiskInfoService riskInfoService;
	
	/**
	 * 查询典型案例
	 * */
	@RequestMapping(value="/queryRiskInfoClaim",method={RequestMethod.GET,RequestMethod.POST})
	public ResponseResult queryRiskInfoClaim() {
		ResponseResult responseResult =new ResponseResult();
		System.out.println("success");
		responseResult =  riskInfoService.queryRiskInfoClaim();
		return responseResult;
	}
}
