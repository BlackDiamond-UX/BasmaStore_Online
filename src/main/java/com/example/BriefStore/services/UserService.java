package com.example.BriefStore.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.BriefStore.models.User;

public interface UserService extends UserDetailsService {

	User getUser(String email);
	@Query("select u from users u where u.id = ?")
	User getUserById(Long id);

	User updateUser(Long id, User user);

	User validateUser(Long id, User user);

	User invalidateUser(Long id, User user);

	void deleteUser(Long id);

	List<User> getUsers(int page, int limit);
}
