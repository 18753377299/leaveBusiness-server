package com.example.riskinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.ResponseResult;
import com.example.riskinfo.dao.RiskInfoClaimDao;

@Service
public class RiskInfoService {
	
	@Autowired
	RiskInfoClaimDao riskInfoClaimDao;
	
	public  ResponseResult queryRiskInfoClaim() {
		ResponseResult responseResult =new ResponseResult();
		
		return responseResult;
	}
}
