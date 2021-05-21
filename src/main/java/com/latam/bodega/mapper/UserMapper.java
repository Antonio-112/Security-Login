package com.latam.bodega.mapper;

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
	
}
