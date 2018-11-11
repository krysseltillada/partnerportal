package com.codebytes.autobook.user.configuration;

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
public class SpringSecurityConfiguration{
    @Configuration
    public static class SpringSecurityUserAdapterConfiguration extends WebSecurityConfigurerAdapter {

        private String[] adminUrls = {"/user/dashboard/**"};
        private String[] ignoreUrls = {"/h2-console/**"};

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password(encoder().encode("user"))
                    .roles("USER");
        }

        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.antMatcher("/user/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("USER")
                    .and()
                    .authorizeRequests()
                    .antMatchers(adminUrls).hasRole("USER")
                    .and()
                    .formLogin()
                    .loginPage("/user")
                    .defaultSuccessUrl("/user/dashboard")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/user?logout")
                    .permitAll()
                    .and()
                    .csrf()
                    .ignoringAntMatchers(ignoreUrls)
                    .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin();
        }

    }
}
