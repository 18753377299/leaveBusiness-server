package com.example.riskinfo.dao;

import java.util.List;

import com.example.riskinfo.po.RiskInfoClaim;
import com.example.riskinfo.vo.RiskClaimVo;

public interface RiskInfoClaimDao {
	//查询典型案例基本信息
	public List<RiskInfoClaim> queryRiskInfoClaim(RiskClaimVo riskClaimVo);
	
}
