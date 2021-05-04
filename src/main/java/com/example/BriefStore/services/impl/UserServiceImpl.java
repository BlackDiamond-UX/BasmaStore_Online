package com.example.BriefStore.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.BriefStore.models.User;
import com.example.BriefStore.repository.UserRepository;
import com.example.BriefStore.security.services.UserDetailsImpl;
import com.example.BriefStore.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException(username);

		return UserDetailsImpl.build(user);
	}

	@Override
	public User getUser(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException(email);
		
		return user;
	}

	
	@Override
	public User getUserById(Long id) {
		Optional<User> optinalEntity = userRepository.findById(id);
		User userEntity = optinalEntity.get();
		if (userEntity == null)
			throw new UsernameNotFoundException("cannot find user with " + id);

		return userEntity;
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> optinalEntity = userRepository.findById(id);
		User userEntity = optinalEntity.get();
		if (userEntity == null)
			throw new UsernameNotFoundException("cannot find user with " + id);
		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(encoder.encode(user.getPassword()));
		
		User userUpdate = userRepository.save(userEntity);
		return userUpdate;
	}

	@Override
	public User validateUser(Long id, User user) {
		Optional<User> optinalEntity = userRepository.findById(id);
		User userEntity = optinalEntity.get();
		if (userEntity == null)
			throw new UsernameNotFoundException("cannot find user with " + id);
		userEntity.setEmailVerificationStatus(true);;
		User userValide = userRepository.save(userEntity);

		return userValide;
	}

	@Override
	public User invalidateUser(Long id, User user) {
		Optional<User> optinalEntity = userRepository.findById(id);
		User userEntity = optinalEntity.get();
		if (userEntity == null)
			throw new UsernameNotFoundException("cannot find user with " + id);
		userEntity.setEmailVerificationStatus(false);
		User userValide = userRepository.save(userEntity);

		return userValide;
	}

	@Override
	public void deleteUser(Long id) {
		Optional<User> optinalEntity = userRepository.findById(id);
		User userEntity = optinalEntity.get();
		if (userEntity == null) throw new UsernameNotFoundException("cannot find user with " + id);
		userRepository.delete(userEntity);
		
	}

	@Override
	public List<User> getUsers(int page, int limit) {
		if(page >0) page -= 1;
		List<User> userslist = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<User> userPage = userRepository.findAll(pageableRequest);
		List<User> users = userPage.getContent();
		
		for(User userEntity: users) {
			User user = new User();
			BeanUtils.copyProperties(userEntity, user);
			userslist.add(user);
		}
		
		return userslist;
	}

}
