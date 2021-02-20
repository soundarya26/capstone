package com.tavant.searchAddress.controller;

import java.util.HashMap;
import java.util.List;
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

import com.tavant.searchAddress.exceptions.AddressNotFoundException;
import com.tavant.searchAddress.model.Address;

import com.tavant.searchAddress.repository.AddressRepository;
@CrossOrigin

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping
	public String get() {
		return "hello from address";
	}
	
	@GetMapping("/all")
	public List<Address> getAllAddress() throws AddressNotFoundException{
		
		return Optional.ofNullable(addressRepository.findAll()).orElseThrow(
						()->new AddressNotFoundException("no record found"));
		
		
	}
	
	@PostMapping("/add")
	public Address addAddress( @RequestBody @Valid Address address) {
			return addressRepository.save(address);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable("id") Integer id)
			throws AddressNotFoundException {
		
		Optional<Address> optional = addressRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			
			throw new AddressNotFoundException("No Address found with this id");
		}
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateaccount(@PathVariable (value = "id") 
	Integer id,@RequestBody Address address) throws AddressNotFoundException{
		Address address1=addressRepository.findById(id).
				orElseThrow(()->new AddressNotFoundException("No address found to  be updated"));
		
		final Address updatedaddress = addressRepository.save(address1);
		return ResponseEntity.ok(updatedaddress);
	}
	
	@DeleteMapping("/{id}")
	public Map<String,Boolean> deleteaddress(@PathVariable(value = "id") Integer id)
	throws AddressNotFoundException{
		Address address=addressRepository.findById(id).
				orElseThrow(()->new AddressNotFoundException("no address found for deletion"));
		
		addressRepository.delete(address);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;

	}
	

}
