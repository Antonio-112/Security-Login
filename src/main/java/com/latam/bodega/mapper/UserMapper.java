package com.latam.bodega.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.latam.bodega.model.Users;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM Users WHERE email = #{email}")
	Users findByEmail(@Param("email") String email);
		
	@Select("SELECT * FROM Users WHERE username = #{username}")
	Users findByUsername(@Param("username") String username);
	
	@Insert("INSERT INTO Users(email, username, password, role) VALUES (#{email}, #{username}, #{password}, #{role})")
	public int registerUser(@Param("email") String email,
			@Param("username") String username,
			@Param("password") String password,
			@Param("role") String role);
	
}
