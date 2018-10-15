//package com.example.demo4.security;
//
//import com.example.demo4.author.MyAuthorFailHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    MyAuthorFailHandler myAuthorFailHandler;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/logina.html")
//                .loginProcessingUrl("/login")
//                .failureHandler(myAuthorFailHandler)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/logina.html","/css/login.css").permitAll()
//                .anyRequest()  // 所有请求
//                .authenticated() // 都需要认证
//                .and().csrf().disable();
//    }
//}
