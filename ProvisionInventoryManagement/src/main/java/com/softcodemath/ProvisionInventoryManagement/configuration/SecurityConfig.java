package com.softcodemath.ProvisionInventoryManagement.configuration;


import com.softcodemath.ProvisionInventoryManagement.service.UserDataDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        return new UserDataDetailService();

    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

/*
        return http .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry->{
                    registry.requestMatchers("/createaccount","/createuser","/user").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();

                }) .formLogin(AbstractAuthenticationFilterConfigurer::permitAll) .build();*/



        return http
                .csrf(custom-> custom.disable())
                .authorizeHttpRequests(registry->registry
                        .requestMatchers("register","login","getusers").permitAll()
                        //.requestMatchers("/admin/**").hasRole("ADMIN")
                        // .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }


    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();

        dao.setUserDetailsService(userDetailsService());

        dao.setPasswordEncoder(passwordEncoder());

        return dao;

    }





}
