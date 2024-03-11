package com.mdb.datasrc.common.dto;

import java.math.BigDecimal;

public class ItemAvailableSummaryDTO {
	
	private BigDecimal totalOnhand;
	private BigDecimal totalDemand;
	private BigDecimal totalSupply;
	private BigDecimal summary;
	public BigDecimal getTotalOnhand() {
		return totalOnhand;
	}
	public void setTotalOnhand(BigDecimal totalOnhand) {
		this.totalOnhand = totalOnhand;
	}
	public BigDecimal getTotalDemand() {
		return totalDemand;
	}
	public void setTotalDemand(BigDecimal totalDemand) {
		this.totalDemand = totalDemand;
	}
	public BigDecimal getTotalSupply() {
		return totalSupply;
	}
	public void setTotalSupply(BigDecimal totalSupply) {
		this.totalSupply = totalSupply;
	}
	public BigDecimal getSummary() {
		return summary;
	}
	public void setSummary(BigDecimal summary) {
		this.summary = summary;
	}
	
	

}
