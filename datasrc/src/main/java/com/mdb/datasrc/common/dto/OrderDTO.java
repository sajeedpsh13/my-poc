package com.mdb.datasrc.common.dto;

import java.math.BigDecimal;

public class OrderDTO {
	private BigDecimal orderNumber;
	private BigDecimal boQty;
	private String lineNumber;
	private BigDecimal lineId;
	private BigDecimal lineQty;
	public BigDecimal getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}
	public BigDecimal getBoQty() {
		return boQty;
	}
	public void setBoQty(BigDecimal boQty) {
		this.boQty = boQty;
	}
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public BigDecimal getLineId() {
		return lineId;
	}
	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}
	public BigDecimal getLineQty() {
		return lineQty;
	}
	public void setLineQty(BigDecimal lineQty) {
		this.lineQty = lineQty;
	}
	
	

}
