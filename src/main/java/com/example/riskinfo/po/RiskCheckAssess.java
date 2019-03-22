package com.example.riskinfo.po;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class RiskCheckAssess {
	
	private String riskCheckNo;
    private BigDecimal envDanger;
    private BigDecimal impDanger;
    private BigDecimal buildDanger;
    private BigDecimal cargoDanger;
    private BigDecimal typDanger;
    private BigDecimal floodDanger;
    private Date insertTimeForHis;
    private Date operateTimeForHis;
	private RiskCheckMain riskCheckMain;
	
	
}
