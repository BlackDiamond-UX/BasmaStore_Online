package com.example.BriefStore.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BriefStore.models.User;
import com.example.BriefStore.request.SignUpRequest;
import com.example.BriefStore.response.JwtResponse;
import com.example.BriefStore.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/user")
@PreAuthorize("hasRole('USER')")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> getUser(@PathVariable Long id) {

		User getUser = userService.getUserById(id);

		JwtResponse userResponse = new JwtResponse();
		BeanUtils.copyProperties(getUser, userResponse);

		return new ResponseEntity<JwtResponse>(userResponse, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> updateUser(@PathVariable Long id, @RequestBody SignUpRequest userRequest) {

		User userDto = new User();
		BeanUtils.copyProperties(userRequest, userDto);

		User updateUser = userService.updateUser(id, userDto);
		JwtResponse userResponse = new JwtResponse();

		BeanUtils.copyProperties(updateUser, userResponse);
		return new ResponseEntity<JwtResponse>(userResponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "/validation/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> validerUser(@PathVariable Long id) {
		
		User getUser = userService.getUserById(id);
		User valideUser = userService.validateUser(id, getUser);
		System.out.println(valideUser);
		JwtResponse userResponse = new JwtResponse();
		BeanUtils.copyProperties(valideUser, userResponse);
		
		return new ResponseEntity<JwtResponse>(userResponse, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/invalidation/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> invaliderUser(@PathVariable Long id) {
		
		User getUser = userService.getUserById(id);
		User invalideUser = userService.invalidateUser(id, getUser);
		System.out.println(invalideUser);
		JwtResponse userResponse = new JwtResponse();
		BeanUtils.copyProperties(invalideUser, userResponse);
		
		return new ResponseEntity<JwtResponse>(userResponse, HttpStatus.ACCEPTED);
	}
}
