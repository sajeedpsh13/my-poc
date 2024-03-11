package com.mdb.datasrc.common.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ItemReservationsDTO {

	private Date requiredDate;
	private String supplyDemandType;
	private String subInventoryCode;
	private String locator;
	private String identifier;
	private BigDecimal demandQty;
	private BigDecimal supplyQty;
	private String uom;
	private BigDecimal lineNumber;
	private Date requestDate;
	private String customerName;
	private BigDecimal availableQty;
	private BigDecimal reservedQty;
	private String lotNumber;
	private BigDecimal reservationType;
	private BigDecimal lineId;
	
	
	public Date getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getSupplyDemandType() {
		return supplyDemandType;
	}
	public void setSupplyDemandType(String supplyDemandType) {
		this.supplyDemandType = supplyDemandType;
	}
	public String getSubInventoryCode() {
		return subInventoryCode;
	}
	public void setSubInventoryCode(String subInventoryCode) {
		this.subInventoryCode = subInventoryCode;
	}
	public String getLocator() {
		return locator;
	}
	public void setLocator(String locator) {
		this.locator = locator;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public BigDecimal getDemandQty() {
		return demandQty;
	}
	public void setDemandQty(BigDecimal demandQty) {
		this.demandQty = demandQty;
	}
	public BigDecimal getSupplyQty() {
		return supplyQty;
	}
	public void setSupplyQty(BigDecimal supplyQty) {
		this.supplyQty = supplyQty;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public BigDecimal getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(BigDecimal lineNumber) {
		this.lineNumber = lineNumber;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BigDecimal getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(BigDecimal availableQty) {
		this.availableQty = availableQty;
	}
	public BigDecimal getReservedQty() {
		return reservedQty;
	}
	public void setReservedQty(BigDecimal reservedQty) {
		this.reservedQty = reservedQty;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public BigDecimal getReservationType() {
		return reservationType;
	}
	public void setReservationType(BigDecimal reservationType) {
		this.reservationType = reservationType;
	}
	public BigDecimal getLineId() {
		return lineId;
	}
	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}
	
	
}
