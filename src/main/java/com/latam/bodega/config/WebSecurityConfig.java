package com.latam.bodega.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_CLIENT = "CLIENT";

	private static final String[] PUBLIC_MATCHERS = { "/css/**", "/js/**", "/webjars/**", "/static/**", "/login" };
	private static final String[] CLIENT_MATCHERS = { "**/user/**" };
	private static final String[] ADMIN_MATCHERS = { "**/admin/**" };

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().antMatchers(CLIENT_MATCHERS)
				.hasRole(ROLE_CLIENT).antMatchers(ADMIN_MATCHERS).hasRole(ROLE_ADMIN).anyRequest().authenticated().and()
				.formLogin().loginPage("/login").successHandler(authenticationSuccessHandler)
				.failureUrl("/login?error=true").usernameParameter("email").passwordParameter("password").and()
				.exceptionHandling().accessDeniedPage("/recurso-prohibido");
	}

	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {

		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
