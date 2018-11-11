package com.codebytes.partnerportal.user.configuration;

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

        private String[] ignoreUrls = {"/h2-console/**"};
        private String[] permitAllUrls = {"/template/**"};

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("customer")
                    .password(encoder().encode("customer"))
                    .roles("CUSTOMER");
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
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
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
