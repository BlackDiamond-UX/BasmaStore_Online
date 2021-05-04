package com.example.BriefStore.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BriefStore.models.ERole;
import com.example.BriefStore.models.Role;
import com.example.BriefStore.models.User;
import com.example.BriefStore.repository.RoleRepository;
import com.example.BriefStore.repository.UserRepository;
import com.example.BriefStore.request.SignUpRequest;
import com.example.BriefStore.response.JwtResponse;
import com.example.BriefStore.response.MessageResponse;
import com.example.BriefStore.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
					Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
		user.setRoles(roles);
		user.setEmailVerificationStatus(true);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> getUser(@PathVariable Long id) {

		User getUser = userService.getUserById(id);

		JwtResponse userResponse = new JwtResponse();
		BeanUtils.copyProperties(getUser, userResponse);

		return new ResponseEntity<JwtResponse>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JwtResponse> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit) {

		List<JwtResponse> userResponse = new ArrayList<>();
		List<User> users = userService.getUsers(page, limit);

		for (User userDto : users) {
			JwtResponse user = new JwtResponse();
			BeanUtils.copyProperties(userDto, user);
			userResponse.add(user);
		}
		return userResponse;
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
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
