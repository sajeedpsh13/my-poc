package com.mdb.datasrc.common.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ItemOnHandDTO {
	
	private String subInventory;
	private String locator;
	private BigDecimal onHandQty;
	private BigDecimal reservedQty;
	private BigDecimal availableQty;
	private BigDecimal onReceiptQty;
	private BigDecimal onDemandQty;
	private BigDecimal onKitQty;
	private BigDecimal kitReceipt;
	
	public String getSubInventory() {
		return subInventory;
	}
	public void setSubInventory(String subInventory) {
		this.subInventory = subInventory;
	}
	public String getLocator() {
		return locator;
	}
	public void setLocator(String locator) {
		this.locator = locator;
	}
	public BigDecimal getOnHandQty() {
		return onHandQty;
	}
	public void setOnHandQty(BigDecimal onHandQty) {
		this.onHandQty = onHandQty;
	}
	public BigDecimal getReservedQty() {
		return reservedQty;
	}
	public void setReservedQty(BigDecimal reservedQty) {
		this.reservedQty = reservedQty;
	}
	public BigDecimal getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(BigDecimal availableQty) {
		this.availableQty = availableQty;
	}
	public BigDecimal getOnReceiptQty() {
		return onReceiptQty;
	}
	public void setOnReceiptQty(BigDecimal onReceiptQty) {
		this.onReceiptQty = onReceiptQty;
	}
	public BigDecimal getOnDemandQty() {
		return onDemandQty;
	}
	public void setOnDemandQty(BigDecimal onDemandQty) {
		this.onDemandQty = onDemandQty;
	}
	public BigDecimal getOnKitQty() {
		return onKitQty;
	}
	public void setOnKitQty(BigDecimal onKitQty) {
		this.onKitQty = onKitQty;
	}
	public BigDecimal getKitReceipt() {
		return kitReceipt;
	}
	public void setKitReceipt(BigDecimal kitReceipt) {
		this.kitReceipt = kitReceipt;
	}
	
	

}
