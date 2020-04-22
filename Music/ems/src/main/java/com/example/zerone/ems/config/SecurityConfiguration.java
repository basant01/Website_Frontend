package com.example.zerone.ems.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.zerone.ems.service.DomainUserDetailsService;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DomainUserDetailsService userDetailsService;

    // setup users and permissions
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // configure authorization rules here
        httpSecurity.cors();
        httpSecurity.csrf().disable();
        httpSecurity
                .authorizeRequests()
                .antMatchers("/api/v1/employee/**")
                .permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                /*
                   Set the sessioncreation policy to avoid using cookies for authentication
                   https://stackoverflow.com/questions/50842258/spring-security-caching-my-authentication/50847571
                 */
               .and().sessionManagement().sessionCreationPolicy(STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //configure users
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(bcryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Primary
    @Bean
    public PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}