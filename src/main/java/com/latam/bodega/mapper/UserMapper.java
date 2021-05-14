package com.latam.bodega.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.latam.bodega.model.Users;

@Mapper
public interface UserMapper {

	@Select("select * from Users where email = #{email}")
	Users findByEmail(@Param("email") String email);

}
