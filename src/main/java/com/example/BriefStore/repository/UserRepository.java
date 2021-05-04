package com.example.BriefStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BriefStore.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
	User findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
	Optional<User> findById(Long Id);
}
