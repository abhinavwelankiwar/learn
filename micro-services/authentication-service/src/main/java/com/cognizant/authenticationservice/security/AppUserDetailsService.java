package com.cognizant.authenticationservice.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cognizant.authenticationservice.controller.AuthenticationController;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.UserRepository;



@Component
public class AppUserDetailsService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);


	@Autowired
	private UserRepository userRepository;
	
	AppUser appUser;
	User user;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		user=userRepository.findUserByUsername(userName).get();
		if(user==null){
			LOGGER.info("USER NOT FOUND");
			throw new UsernameNotFoundException("Username not Found");
		}else{
			appUser= new AppUser(user);
		}
		
		return appUser;
	}
	
	public void signup(User user) throws Exception{
		Optional<User> userObj= userRepository.findUserByUsername(user.getUserName());
		if(userObj.isPresent()){
			throw new Exception("User already exists");
		}else{
			System.out.println(user);
			String pass=user.getPassword();
			user.setPassword(passwordEncoder().encode(pass));
			userRepository.save(user);
			User newUser= userRepository.findUserByUsername(user.getUserName()).get();
			userRepository.addUserRole(newUser.getUserId(),2);
		}
	}
	
	public PasswordEncoder passwordEncoder() {
		//LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

}
