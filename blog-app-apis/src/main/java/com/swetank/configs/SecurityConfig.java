package com.swetank.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.swetank.security.CustomUserDetailService;
import com.swetank.security.JwtAuthenticationEntryPoint;
import com.swetank.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	 @Autowired
	 private JwtAuthenticationEntryPoint point;
	 
	 @Autowired
	 private JwtAuthenticationFilter filter;

	@SuppressWarnings("deprecation")
	@Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.csrf(csrf -> csrf.disable())
		     .cors(cors -> cors.disable())
		     .authorizeHttpRequests(auth -> auth.requestMatchers("/api/")
		    		 .authenticated().requestMatchers("/auth/login")
		    		 .permitAll().anyRequest().authenticated())
		             .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
		             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		 
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
	    }
	 
	 
	
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder()); 
	 }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
}
