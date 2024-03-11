package com.mdb.datasrc.repo.secondary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdb.datasrc.model.secondary.XxspCustomerLanguagesV;

@Repository
public interface XxspCustomerLanguagesVRepo extends JpaRepository<XxspCustomerLanguagesV, String>{

}