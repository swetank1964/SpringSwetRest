package com.swetank.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.swetank.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.csrf(AbstractHttpConfigurer::disable)
	        .cors(Customizer.withDefaults())
	                .authorizeHttpRequests(auth ->
	                        auth
	                                .requestMatchers("/api")
	                                .permitAll().anyRequest()
	                                .authenticated())
	                .sessionManagement(session ->
	                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .httpBasic(Customizer.withDefaults());


	        return httpSecurity.build();
	    }
	 
	 
	
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder()); 
	 }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}
