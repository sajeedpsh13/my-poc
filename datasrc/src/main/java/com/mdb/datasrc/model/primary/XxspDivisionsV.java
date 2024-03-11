package com.mdb.datasrc.model.primary;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="XXSP_PHYCOUNTS_DIVISIONS_V")
public class XxspDivisionsV {

	@Id
	@Column(name="ORGANIZATION_ID")
	private BigDecimal divisionId;


	@Column(name="ORGANIZATION_CODE")
	private String division;

	@Column(name="ORGANIZATION_NAME")
	private String divisionName;
	
	@Column(name="USER_ID")
	private BigDecimal userId;

	public BigDecimal getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(BigDecimal divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	
}
