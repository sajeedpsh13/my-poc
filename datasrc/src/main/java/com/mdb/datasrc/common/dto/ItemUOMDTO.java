package com.mdb.datasrc.common.dto;

import java.math.BigDecimal;

public class ItemUOMDTO {
	private String primaryUomCode;
	private String uom;
	private BigDecimal convRate;
	private String fromQty;
	private String toQty;
	
	public String getPrimaryUomCode() {
		return primaryUomCode;
	}
	public void setPrimaryUomCode(String primaryUomCode) {
		this.primaryUomCode = primaryUomCode;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public BigDecimal getConvRate() {
		return convRate;
	}
	public void setConvRate(BigDecimal convRate) {
		this.convRate = convRate;
	}
	public String getFromQty() {
		return fromQty;
	}
	public void setFromQty(String fromQty) {
		this.fromQty = fromQty;
	}
	public String getToQty() {
		return toQty;
	}
	public void setToQty(String toQty) {
		this.toQty = toQty;
	}
	

	
}
