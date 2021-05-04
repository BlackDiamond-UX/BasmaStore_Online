package com.example.BriefStore.request;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignUpRequest {

	@NotBlank(message = "Please enter your name !")
	@Size(min = 6, message = "Ce champ doit avoir au moins 6 caracteres !")
	private String username;

	@NotBlank(message = "Please enter your email !")
	@Email(message = "Ce champ doit respecter le format email !")
	private String email;

	@NotBlank(message = "Please enter a password !")
	@Size(min = 8, message = "Mot de passe doit avoir au moins 8 caracteres !")
	@Size(max = 12, message = "Mot de passe doit avoir au max 12 caracteres !")
	@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "Ce mot de passe doit avoir des lettres en maj et minsc et numero")
	private String password;
	
	private Set<String> role;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(HashSet<String> role) {
		this.role = role;
	}
	
	
}
