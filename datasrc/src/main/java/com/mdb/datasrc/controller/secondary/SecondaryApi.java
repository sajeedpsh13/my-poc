package com.mdb.datasrc.controller.secondary;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdb.datasrc.model.secondary.XxspCustomerLanguagesV;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/db2/customers")
@Api(value = "customers")
public interface SecondaryApi {

	@ApiOperation(value = "Get Customer Languages", tags={ "customers" })
	@ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation",response = XxspCustomerLanguagesV.class, responseContainer = "List")})
	@GetMapping("/customer-languages")
	default ResponseEntity<List<XxspCustomerLanguagesV>> getCustomerLanguages() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
