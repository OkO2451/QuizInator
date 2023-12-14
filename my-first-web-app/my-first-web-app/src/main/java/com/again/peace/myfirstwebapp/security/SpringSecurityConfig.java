package com.again.peace.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;
import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {



    @Bean
    public InMemoryUserDetailsManager createInMemoryUserDetailsManager(){

        UserDetails user = getUserDetails(getUsername(),getPassword());
        UserDetails user2 = getUserDetails("ok","ok");
        UserDetails user3 = getUserDetails("1234","1234");
        return new InMemoryUserDetailsManager(user,user2,user3);
    }

    private UserDetails getUserDetails(String Username , String password ) {
        Function<String , String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails user =  User.builder()
                .passwordEncoder(passwordEncoder)
                .username(Username)
                .roles("USER","ADMIN")
                .password(password).build();
        return user;
    }

    private String getPassword() {
        return "password";
    }

    private String getUsername() {
        return "username";
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        http.formLogin(withDefaults());

        http.csrf(csrf->csrf.disable());
        http.headers(header -> header.disable());



        return http.build();
    }
}
