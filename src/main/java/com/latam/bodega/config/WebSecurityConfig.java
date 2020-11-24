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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		//auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("miawmiaw")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("miawmiaw")).roles("USER");
	}
	
	
@Override
public void configure(HttpSecurity http) throws Exception{
	http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("CLIENT")
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.successHandler(authenticationSuccessHandler)
			.failureUrl("/login?error=true")
			.usernameParameter("email")
			.passwordParameter("password")
			//.defaultSuccessUrl("/client")
			.and()
			.exceptionHandling()
			.accessDeniedPage("/recurso-prohibido");
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
