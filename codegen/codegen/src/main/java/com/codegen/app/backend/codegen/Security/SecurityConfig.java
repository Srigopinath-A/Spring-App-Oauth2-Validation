package com.codegen.app.backend.codegen.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @SuppressWarnings({ "deprecation", "removal" })
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/User/Add", "/User/Sub").hasAuthority("APPROLE_Admin")  // Admin-only
                .requestMatchers("/User/Add").hasAnyAuthority("APPROLE_Admin" ,"APPROLE_Guest_user") // for both user and guest.
                .anyRequest().authenticated() // Require authentication for other URLs
            .and()
            .oauth2Login();  // Enable OAuth2 login using Azure AD

        return http.build();
    }
}

