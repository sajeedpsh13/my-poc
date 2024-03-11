package com.mdb.datasrc.common.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mdb.datasrc.common.dto.ItemResponseDTO;
import com.mdb.datasrc.common.dto.ItemSearchRegionsResDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/v1/public")
@Api(value = "public")
public interface CommonApi {

	@ApiOperation(value = "get Item regions", tags={ "public" })
	@ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "successful operation", response = ItemSearchRegionsResDTO.class)})
	@GetMapping("/item-regions")
	default ResponseEntity<ItemSearchRegionsResDTO> getRegions() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "Get Item Details", tags = { "supplydemand" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation", response = ItemResponseDTO.class) })
	@GetMapping("/get-item-details")
	default ResponseEntity<ItemResponseDTO> getItemDetails(@RequestParam(name = "divisionId") BigDecimal divisionId,
			@RequestParam(name = "itemId") BigDecimal itemId, @RequestParam(name = "db", required = false) String db) {
		// divisionId=6436&itemId=5594
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
