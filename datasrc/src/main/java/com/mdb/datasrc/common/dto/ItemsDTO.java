package com.mdb.datasrc.common.dto;

import java.math.BigDecimal;

public class ItemsDTO {
	
	private String item;
	private String description;
	private BigDecimal itemId;
	private String uom;
	private String cadItemDescription;
	private BigDecimal weight;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getItemId() {
		return itemId;
	}
	public void setItemId(BigDecimal itemId) {
		this.itemId = itemId;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getCadItemDescription() {
		return cadItemDescription;
	}
	public void setCadItemDescription(String cadItemDescription) {
		this.cadItemDescription = cadItemDescription;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	

}
