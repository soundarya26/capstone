package com.tavant.searchAddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.searchAddress.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

}
