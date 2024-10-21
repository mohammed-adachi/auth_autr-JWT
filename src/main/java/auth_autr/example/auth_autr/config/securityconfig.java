package auth_autr.example.auth_autr.config;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import auth_autr.example.auth_autr.service.serviceUser;

import org.springframework.security.config.core.*;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;



@Configuration
@EnableWebSecurity
public class securityconfig {
@Value("${security.jwt.secret-key}")
private String secretKey;

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                    authz->authz
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/store").permitAll()
                        .requestMatchers("/admin/**").permitAll()
                        .requestMatchers("/client/**").permitAll()
                        .requestMatchers("/acount").permitAll()
                        .requestMatchers("/acount/login").permitAll()
                        .requestMatchers("/acount/register").permitAll()
                        .anyRequest().authenticated() 
                )
                                          
                .oauth2ResourceServer(
                    oauth2->oauth2
                        .jwt(
                            Customizer.withDefaults()
                        )  )
                .sessionManagement(session->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                
                .build();

}
@Bean
public JwtDecoder jwtDecoder() {
    var sucretKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
    return NimbusJwtDecoder.withSecretKey(sucretKey)
    .macAlgorithm(MacAlgorithm.HS256)
    .build();
}
@Bean
public AuthenticationManager authentificationManager(serviceUser serviceUser) {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(serviceUser);
    provider.setPasswordEncoder(new BCryptPasswordEncoder());

    return new ProviderManager(provider);

}
}