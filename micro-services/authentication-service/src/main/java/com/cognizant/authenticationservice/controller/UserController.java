package com.cognizant.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.security.AppUser;
import com.cognizant.authenticationservice.security.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Autowired
	private AppUserDetailsService appUserDetailService;
	
	@PostMapping()
	public void signup(@RequestBody User user) {
		try {
			appUserDetailService.signup(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/{username}")
	public long getUsersId(@PathVariable String username){
		AppUser userDetails= (AppUser) appUserDetailService.loadUserByUsername(username);
		User user=userDetails.getUser();
		return user.getUserId();
	}
	
	

	public PasswordEncoder passwordEncoder() {
		// LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

}
