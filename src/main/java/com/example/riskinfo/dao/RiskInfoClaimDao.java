package com.example.riskinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.riskinfo.po.RiskInfoClaim;

@Mapper
public interface RiskInfoClaimDao {
	//查询典型案例基本信息
	public List<RiskInfoClaim> queryRiskInfoClaim();
}
