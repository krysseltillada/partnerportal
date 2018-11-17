package com.codebytes.partnerportal.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
	@Configuration
	public static class SpringSecurityAdminAdapterConfiguration extends WebSecurityConfigurerAdapter {
		
		private String[] adminUrls = {"/dashboard/**"};
		private String[] permitAllUrls = {"/template/**"};
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
					.withUser("admin")
					.password(encoder().encode("admin"))
					.roles("ADMIN");
		}
		
		@Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.antMatcher("/**")
					.authorizeRequests()
					.antMatchers(permitAllUrls)
					.permitAll()
					.anyRequest().hasRole("ADMIN")
					.and()
				.authorizeRequests()
				.antMatchers(adminUrls).hasRole("ADMIN")
					.and()
				.formLogin()
					.loginPage("/")
					.defaultSuccessUrl("/dashboard")
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/?logout")
					.permitAll()
					.and()
				.headers()
					.frameOptions()
					.sameOrigin();
		}

	}
}
