package com.latam.bodega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.latam.bodega.mapper.UserMapper;
import com.latam.bodega.model.Users;

@Service
public class RegisterServiceImpl implements RegisterService{


	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public String registerUser(Users user) {
		try {
			userMapper.registerUser(user.getEmail(), user.getUsername(), encoder.encode(user.getPassword()), "CLIENT");
			return "ok";
		} catch (Exception e) {
			return "error in register service";
		}
	}

}
