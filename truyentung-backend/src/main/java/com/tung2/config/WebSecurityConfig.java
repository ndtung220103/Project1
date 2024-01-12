package com.tung2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Autowired
	//private RetailStoreUserDetails retailStoreUserDetails;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                   .antMatchers("/admin").authenticated()// Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                   // .antMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().permitAll()// Tất cả các request khác đều cần phải xác thực mới được truy cập
                    .and().csrf().ignoringAntMatchers("/dang-ki","api/login")
                    .and()
                .formLogin()// Cho phép người dùng xác thực bằng form logig
                    .loginPage ("http://127.0.0.1:5500/login.html")
                    .permitAll() // Tất cả đều được truy cập vào địa chỉ này
                    .and()
             /*   .rememberMe()
                .rememberMeServices(tokenBasedRememberMeServices())
                .key("remember-me-key")
                .and()*/
                .logout() // Cho phép logout
                    .permitAll();
        http.csrf().disable();
    }
	/*
	@Bean
    public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
        return new TokenBasedRememberMeServices("remember-me-key", retailStoreUserDetails );
    }*/
}
