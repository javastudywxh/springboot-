package com.wxh.email2.config;

import com.wxh.email2.Service.impl.UsersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * @Auther: WXH
 * @Date: 2022/9/20 - 09 - 20 - 14:02
 */
@CrossOrigin
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UsersService service;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(service)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/api/auth/access-deny")
                .loginProcessingUrl("/api/auth/login")
                .successForwardUrl("/api/auth/login-success")
                .failureForwardUrl("/api/auth/login-failure")
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessUrl("/api/auth/logout-success")
                .and()
                .csrf()
                .disable()
                .cors();
    }
    @Bean
    public CorsFilter corsFilter() {
        //??????CorsConfiguration?????????????????????
        CorsConfiguration config = new CorsConfiguration();
        //?????????????????????????????????????????????????????????
        config.addAllowedOrigin("*");
        //?????????????????????????????????????????? config.addAllowedOrigin("http://localhost:2222");
        //????????????????????????????????????
        config.addAllowedHeader("*");
        //???????????????????????????*????????????
        config.addAllowedMethod("*");
        //??????????????????Cookie????????????????????????????????????JSESSIONID?????????Cookie?????????
        config.setAllowCredentials(true);
        //????????????
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        //??????CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }
}
