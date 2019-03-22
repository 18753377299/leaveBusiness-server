package com.example.riskinfo.dao;

import java.util.List;

import com.example.riskinfo.po.RiskInfoClaim;
import com.example.riskinfo.vo.RiskInfoClaimRequestVo;

public interface RiskInfoClaimDao {
	//查询典型案例基本信息
	public List<RiskInfoClaim> queryRiskInfoClaim(RiskInfoClaimRequestVo riskInfoClaimRequestVo);
	//查询出典型案例的总数
	public Integer queryCountRiskInfoClaim(RiskInfoClaimRequestVo riskInfoClaimRequestVo);
	
	
}
