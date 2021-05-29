package org.wq.spring_security_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SpringSecurityDemoApplicationTests {

    @Test
    public void test() {
        // 使用security里的passwordencoder加密
        PasswordEncoder pw = new BCryptPasswordEncoder();

        //加密
        String encode = pw.encode("123");
        System.out.println(encode);

        //匹配密码
        boolean matches = pw.matches("123", encode);
        System.out.println(matches);
    }

}
