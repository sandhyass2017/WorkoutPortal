package com.workout.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/registration").permitAll().anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.usernameParameter("userName")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/access-denied");

	}

}