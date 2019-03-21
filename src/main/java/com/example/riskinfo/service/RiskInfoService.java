package com.example.riskinfo.service;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.ResponseResult;
import com.example.riskinfo.dao.RiskInfoClaimDao;
import com.example.riskinfo.po.RiskInfoClaim;
import com.example.riskinfo.vo.RiskClaimVo;

@Service
public class RiskInfoService {
	
	@Autowired
	RiskInfoClaimDao riskInfoClaimDao;
	
	public  ResponseResult queryRiskInfoClaim(RiskClaimVo riskClaimVo) {
		ResponseResult responseResult =new ResponseResult();
		
		try {
			RiskInfoClaim riskInfoClaimNew =new RiskInfoClaim();
			//进行字段的复制
			BeanUtils.copyProperties(riskInfoClaimNew, riskClaimVo);
			List<RiskInfoClaim> riskInfoClaimList = riskInfoClaimDao.queryRiskInfoClaim(riskInfoClaimNew);
			for (RiskInfoClaim riskInfoClaim : riskInfoClaimList) {
				System.out.println(riskInfoClaim.getSerialNo() + ":" + riskInfoClaim.getInsertTimeForHis());
			}
			responseResult.setResult(riskInfoClaimList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseResult;
	}
}
