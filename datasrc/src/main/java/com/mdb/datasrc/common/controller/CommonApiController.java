package com.mdb.datasrc.common.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mdb.datasrc.common.dto.ItemResponseDTO;
import com.mdb.datasrc.common.dto.ItemSearchRegionsResDTO;
import com.mdb.datasrc.common.repo.CommonRepo;

import io.swagger.annotations.Api;

@RestController
@Api(value = "public", tags={ "public" })
public class CommonApiController implements CommonApi {
	@Autowired
	private CommonRepo commonRepo; 
	
	@Override
	public ResponseEntity<ItemSearchRegionsResDTO> getRegions() {
		return  ResponseEntity.ok(commonRepo.getRegions());
	}
	
	@Override
	public ResponseEntity<ItemResponseDTO> getItemDetails(BigDecimal divisionId, BigDecimal itemId, String db) {
		return ResponseEntity.ok(commonRepo.getItemDetails(divisionId, itemId, db));
	}
	
	
}
