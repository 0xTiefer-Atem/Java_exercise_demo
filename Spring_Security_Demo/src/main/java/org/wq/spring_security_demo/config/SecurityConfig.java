package org.wq.spring_security_demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;

/**
 * @Author WangQian
 * @Date 2021/5/20 下午 3:13
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    //这个方法中配置基于内存的用户名和密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("wq")
                .password("123456")
                .roles("admin");
    }

    //其他资源直接通过
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    //这个方法中配置登陆页
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html") //配置登录页面
                .loginProcessingUrl("/doLogin") // 配置登录接口 若不配置则登录接口默认与登录页面路径相同
                // 修改传入的参数 默认是username和password
//                .usernameParameter("name")
//                .passwordParameter("pwd")
                // 登录成功回调返回json数据
                .successHandler(((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
                    out.flush();
                    out.close();

                }))

                //失败回调
                .failureHandler(((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(e.getMessage()));
                    out.flush();
                    out.close();
                }))

                // 登陆成功之后的路径跳转方法
//                .successForwardUrl("/s") //验证成功跳转路径 是在服务端进行跳转  默认成功跳转路径是 "/"
//                .defaultSuccessUrl("/s") //重定向
//                .failureUrl("/f")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // 注销地址 ，默认 logout get请求

                //注销成功之后的回调函数
                .logoutSuccessHandler(((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString("注销成功"));
                    out.flush();
                    out.close();

                }))
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))  //使用post方法进行注销
//                .logoutUrl("/login.html")  //注销成功之后跳转路径

                //清楚session信息和认证信息  默认都是true
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .and()
                .csrf().disable()

                //用户未进行认证处理逻辑
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString("尚未登陆，请登录"));
                    out.flush();
                    out.close();
                });
    }
}
