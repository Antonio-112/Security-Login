package com.latam.bodega.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.latam.bodega.mapper.UserMapper;
import com.latam.bodega.model.Users;

@Service
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = userMapper.findByEmail(email);
		if (users == null) throw new UsernameNotFoundException(email);		
		List<GrantedAuthority> authorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(users.getRole().toString())));
		return new User(users.getEmail(), users.getPassword(), authorities);
	}
}
