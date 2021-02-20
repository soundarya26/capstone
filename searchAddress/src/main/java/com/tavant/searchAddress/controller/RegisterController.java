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

import com.tavant.searchAddress.exceptions.AccountNotExistsException;
import com.tavant.searchAddress.exceptions.PasswordNotMatchException;
import com.tavant.searchAddress.model.Register;
import com.tavant.searchAddress.repository.RegisterRepository;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/register")
public class RegisterController {
	
	@Autowired
	RegisterRepository registerRepository;
	
	@GetMapping
	public String getAccount() {
		return "hello from register";
	}
	
	
	@PostMapping("/add")
	public Register addAccount( @RequestBody @Valid Register account)
		//	throws PasswordNotMatchException 
	{
		return registerRepository.save(account);
//		if(account.getPassword().equals(account.getPassword2())) {
//			return registerRepository.save(account);
//		}
//		else {
//			
//			throw new PasswordNotMatchException("password does not match");
		}
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountByEmail(@PathVariable("id") Integer id)
			throws AccountNotExistsException {
		
		Optional<Register> optional = registerRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			
			throw new AccountNotExistsException("No Account Found with this Account");
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateaccount(@PathVariable (value = "id") 
	Integer id,@RequestBody Register account) throws AccountNotExistsException{
		Register account1=registerRepository.findById(id).
				orElseThrow(()->new AccountNotExistsException("No Account found with this mail"));
		
		final Register updatedaccount = registerRepository.save(account1);
		return ResponseEntity.ok(updatedaccount);
	}
	
	@DeleteMapping("/{id}")
	public Map<String,Boolean> deleteticket(@PathVariable(value = "id") Integer id)
	throws AccountNotExistsException{
		Register account1=registerRepository.findById(id).
				orElseThrow(()->new AccountNotExistsException("no account found for deletion"));
		
		registerRepository.delete(account1);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;

	}
	

}
