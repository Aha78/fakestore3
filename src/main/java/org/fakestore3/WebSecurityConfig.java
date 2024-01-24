package org.fakestore3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.*;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

import javax.sql.DataSource;

import java.io.IOException;
import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    DataSource dataSource;
    private static final ClearSiteDataHeaderWriter.Directive[] SOURCE =
            {CACHE, COOKIES, STORAGE, EXECUTION_CONTEXTS};

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder()).usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");


    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests

                                .requestMatchers("/", "/login").permitAll()
                                 .requestMatchers("/", "/user").permitAll()
                                .requestMatchers("/", "/store").authenticated()
                                .requestMatchers("/", "/basket").authenticated()

                                //allows register page through
                                .requestMatchers( "/user").hasRole("*").anyRequest().permitAll()





                )


                .httpBasic(withDefaults());


        http.csrf(csrf -> csrf.disable())

                .logout(logout -> logout.logoutUrl("/logout")


                                .addLogoutHandler((request, response, auth) -> {
                                    for (Cookie cookie : request.getCookies()) {

                                        System.err.println(cookie.getName());
                                        String cookieName = cookie.getName();
                                        Cookie cookieToDelete = new Cookie(cookieName, null);
                                        cookieToDelete.setMaxAge(0);
                                        response.addCookie(cookieToDelete);
                                    }
                                    request.getSession(false).invalidate();
                                    return;
                                })
                        );





        http
                .csrf().disable()
                .formLogin()

                .loginPage("/login");


        return http.build();
    }


}