package com.mdb.datasrc.controller.primary;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdb.datasrc.model.primary.XxspDivisionsV;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/db1/lookup")
@Api(value = "lookup")
public interface PrimaryApi {

	@ApiOperation(value = "Get Divisions by code if division code is present otherwise returns divisions by division name. Only one of the param will be considered.", tags={ "lookup" })
	@ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "successful operation", 
	        		response = XxspDivisionsV.class, responseContainer = "List")})
	@GetMapping("/divisions")
	default ResponseEntity<List<XxspDivisionsV>> getDivisions() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
