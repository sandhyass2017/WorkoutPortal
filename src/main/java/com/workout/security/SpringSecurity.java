package com.workout.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers()
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Expose-Headers", "Authorization,content-type"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "Authorization,content-type"))
				.addHeaderWriter(
						new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, PUT, DELETE, OPTIONS"))
				//.and().cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/user/**").permitAll().antMatchers(HttpMethod.GET, "/user")
				.and().cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/**").permitAll().antMatchers(HttpMethod.GET, "/**/**")
				.permitAll().anyRequest().authenticated().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

	}

}