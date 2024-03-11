package com.mdb.datasrc.model.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="XXSP_LANGUAGE_V")
public class XxspCustomerLanguagesV {

	@Id
	@Column(name="CODE")
	private String code;

	@Column(name="VALUE")
	private String value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}