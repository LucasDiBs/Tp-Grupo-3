package com.unla.grupo03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	CustomSuccessHandler getCustomSuccessHandler() {
		
		return new CustomSuccessHandler();
	}

    @Bean
    UserDetailsService getUserDetailsService() {		
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

		http	
			.csrf(AbstractHttpConfigurer::disable)
			.cors(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(auth -> {
				auth.requestMatchers("/**").permitAll();
				auth.requestMatchers("/user/**").hasRole("USER");
				auth.requestMatchers("/admin/**").hasRole("ADMIN");
				auth.anyRequest().authenticated();
				}
			)
			.formLogin(login -> {
				login.loginPage("/signin");
				login.permitAll();
				login.loginProcessingUrl("/login");
				login.usernameParameter("email");
				login.passwordParameter("password");
				login.successHandler(getCustomSuccessHandler());						
				})
			.formLogin( logout -> {
				logout.permitAll();
			})			
			.httpBasic(Customizer.withDefaults());		
		
		return http.build();
		}
 
	@Bean
	PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

    @Bean
    DaoAuthenticationProvider getDaoAthProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(); 
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		
		return daoAuthenticationProvider;		
	}
	
    
	protected void configure(AuthenticationManagerBuilder auth) {		
		auth.authenticationProvider(getDaoAthProvider());
	} 
	
}
