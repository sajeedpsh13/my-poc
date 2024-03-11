package com.mdb.datasrc.repo.primary;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdb.datasrc.model.primary.XxspDivisionsV;


public interface XxspDivisionsVRepo extends JpaRepository<XxspDivisionsV, BigDecimal> {

	List<XxspDivisionsV> findByDivisionOrDivisionNameContainsIgnoreCase(String divisionCode, String divisionName);
	List<XxspDivisionsV> findByDivisionContainsIgnoreCaseAndUserId(String divisionCode, BigDecimal userId);
	List<XxspDivisionsV> findByDivisionNameContainsIgnoreCaseAndUserId(String divisionName, BigDecimal userId);
	
}
