package org.levell.example.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        http
                .csrf()
                .disable()

                .authorizeExchange()
                .pathMatchers("/login")
                .permitAll()

                .and()
                .authorizeExchange()
                .pathMatchers("/dashboard/**")
                .authenticated()
                .and()
                .formLogin(withDefaults())

                .authorizeExchange()
                .pathMatchers("/api/**")
                .authenticated()
                .and()
                .httpBasic(withDefaults());
        return http.build();
    }
}
