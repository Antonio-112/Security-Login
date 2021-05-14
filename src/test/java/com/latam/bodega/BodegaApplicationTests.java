package com.latam.bodega;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BodegaApplicationTests {

	@Autowired 
	BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		String contrasenha_admin = "admin";
		String contrasenha_cliente = "cliente";
		
		System.out.println("Contraseña admin: " + encoder.encode(contrasenha_admin));
		System.out.println("Contraseña cliente: " + encoder.encode(contrasenha_cliente));
	}

}
