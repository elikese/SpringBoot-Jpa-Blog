package com.study.blog.test;

import com.study.blog.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    //http://localhost:8000/blog/dummy/join (요청)
    //http의 body에 username, password, email 데이터를 정확히 가지고 요청하게 되면(JSON아님)
    //@RequestParam으로 key값 지정을 안해도 들어옴(JSON아님 주의)
    @PostMapping(value = "/dummy/join")
    public String join(String username, String password, String email) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);
        return "회원가입 완료";
    }

    // Object로도 데이터 받기 가능
    @PostMapping(value = "/dummy/join2")
    public String join2(User user) {
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getPassword());
        return "회원가입 완료";
    }
}
