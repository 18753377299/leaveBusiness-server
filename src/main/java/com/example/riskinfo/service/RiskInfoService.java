package com.example.riskinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.ResponseResult;
import com.example.riskinfo.dao.RiskInfoClaimDao;
import com.example.riskinfo.po.RiskInfoClaim;

@Service
public class RiskInfoService {
	
	@Autowired
	RiskInfoClaimDao riskInfoClaimDao;
	
	public  ResponseResult queryRiskInfoClaim() {
		ResponseResult responseResult =new ResponseResult();
		List<RiskInfoClaim> riskInfoClaimList = riskInfoClaimDao.queryRiskInfoClaim();
		for(RiskInfoClaim riskInfoClaim:riskInfoClaimList) {
			System.out.println(riskInfoClaim.getSerialNo()+":"+riskInfoClaim.getInsertTimeForHis());
		}
		responseResult.setResult(riskInfoClaimList);
		return responseResult;
	}
}
