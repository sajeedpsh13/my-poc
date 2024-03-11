package com.mdb.datasrc.controller.primary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mdb.datasrc.model.primary.XxspDivisionsV;
import com.mdb.datasrc.repo.primary.XxspDivisionsVRepo;

import io.swagger.annotations.Api;

@RestController
@Api(value = "lookup", tags={ "lookup" })
public class PrimaryController implements PrimaryApi {
	@Autowired
	private XxspDivisionsVRepo xxspDivisionsVRepo;

	@Override
	public ResponseEntity<List<XxspDivisionsV>> getDivisions() {
		return ResponseEntity.ok(xxspDivisionsVRepo.findAll());
	}
}
