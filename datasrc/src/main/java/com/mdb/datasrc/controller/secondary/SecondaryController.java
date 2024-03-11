package com.mdb.datasrc.controller.secondary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mdb.datasrc.model.secondary.XxspCustomerLanguagesV;
import com.mdb.datasrc.repo.secondary.XxspCustomerLanguagesVRepo;

import io.swagger.annotations.Api;

@RestController
@Api(value = "customers", tags={ "customers" })
public class SecondaryController implements SecondaryApi{
	@Autowired
	private XxspCustomerLanguagesVRepo xxspCustomerLanguagesVRepo;

	@Override
	public  ResponseEntity<List<XxspCustomerLanguagesV>>getCustomerLanguages() {
		return ResponseEntity.ok(xxspCustomerLanguagesVRepo.findAll());
	}
}
