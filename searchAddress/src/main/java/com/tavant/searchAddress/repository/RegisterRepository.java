package com.tavant.searchAddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.searchAddress.model.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer>{

}
