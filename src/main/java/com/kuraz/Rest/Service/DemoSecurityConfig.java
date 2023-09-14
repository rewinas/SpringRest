package com.kuraz.Rest.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

//        return  new JdbcUserDetailsManager(dataSource);
//        Custom Queries
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//define query to retrieve a user by username
jdbcUserDetailsManager.setUsersByUsernameQuery(
        "select user_id,pw,active from members where user_id=?"
);
        //define query to retrieve the authorities/roles by username
jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
        "select user_id, role from roles where user_id=?"
);
return jdbcUserDetailsManager;
    }


//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails biruk = User.builder()
//                .username("biruk")
//                .password("{noop}password")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails marry = User.builder()
//                .username("marry")
//                .password("{noop}password")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//        UserDetails daniel = User.builder()
//                .username("daniel")
//                .password("{noop}password")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(biruk,marry,daniel);
//    }
//
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/magic-api/books").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/magic-api/books/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/magic-api/books").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/magic-api/books").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE,"/magic-api/books/**").hasRole("ADMIN")

        );

        //use HTTP Basic Authentication
        http.httpBasic();

        //disabled the CSRF
        http.csrf().disable();

return  http.build();
    }


}
