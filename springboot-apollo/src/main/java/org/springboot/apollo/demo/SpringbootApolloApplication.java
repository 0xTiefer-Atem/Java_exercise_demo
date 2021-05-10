package org.springboot.apollo.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
@MapperScan(basePackages = "org.springboot.apollo.demo.mapper")
public class SpringbootApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApolloApplication.class, args);
    }

}
