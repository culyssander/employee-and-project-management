package com.culysoft.usermodule.config;

//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
public class SecurityConfig {
//    @Autowired
//    private JWTFilter authFilter;

//    @Autowired
//    private UserDetailsService userDetailsService;
//
////    @Bean
//    public UserDetailsService userDetailsService() {
//        return userDetailsService;
//    }
//
////    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> {
//                    auth
//                            .requestMatchers("/**", HttpMethod.GET.name()).permitAll()
//                            .requestMatchers("/swagger-ui/**").permitAll()
//                            .requestMatchers("/v3/api-docs/**").permitAll()
////                            .requestMatchers("/api/v1/sign", HttpMethods.POST).permitAll()
////                            .requestMatchers("/api/v1/forgot-password/**", HttpMethods.POST).permitAll()
////                            .requestMatchers("/api/v1/confirm-reset", HttpMethods.PUT).permitAll()
//////                            .requestMatchers("/api/v1/publicacoes", HttpMethods.POST).authenticated()
//////                            .requestMatchers("/api/v1/publicacoes/**", HttpMethods.PUT).authenticated()
////                            .requestMatchers("/api/v1/publicacoes/**").permitAll()
////                            .requestMatchers("")
//                            .requestMatchers("/api/v1/users/register").permitAll()
//                            .requestMatchers("/api/v1/me").authenticated();
//                })
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
////    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
}
