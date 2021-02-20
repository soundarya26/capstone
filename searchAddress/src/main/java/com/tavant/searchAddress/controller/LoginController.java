package com.tavant.searchAddress.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.searchAddress.exceptions.LoginFailedException;
import com.tavant.searchAddress.model.Login;
import com.tavant.searchAddress.model.Register;
import com.tavant.searchAddress.repository.LoginRepository;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping
	public String getAccount() {
		return "hello from login";
	}
	
	
	@PostMapping("/add")
	public Login addAccount( @RequestBody @Valid Login account,@RequestBody Register account1)
			throws LoginFailedException {
		
		if((account.getEmail().equals(account1.getEmail())) &&
				(account.getPassword().equals(account1.getPassword2()))) {
			
			return loginRepository.save(account);
		}
		else {
			throw new LoginFailedException("email and password you entered does not match");
		}
	}
	
	
	
	
	
	


}
