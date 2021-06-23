package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hibernate.criterion.Restrictions.and;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                   .withUser("ADMIN")
                   .password("admin")
                   .roles("ADMIN")
                    .and()
                   .withUser("user")
                   .password("user")
                   .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()

                .antMatchers("/last_news/add").hasRole("ADMIN")
                .antMatchers("//last_news/{id}/edit").hasRole("ADMIN")
                .antMatchers("//last_news/{id}/delete").hasRole("ADMIN")
                .antMatchers("/about").hasAnyRole("USER","ADMIN")
                .antMatchers("/last_news").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .csrf().disable()
                .formLogin();

    }

    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
