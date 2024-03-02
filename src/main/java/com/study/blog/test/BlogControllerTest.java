package com.study.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 스프링이 com.study.bolg 이하를 스캔해서 모든 파일을 메모리에 생성하는것은 아니고,
// 특정 anotation이 붙어있는 클래스 파일들을 new해서(IOC) 스프링 컨테이너에 싱글톤패턴으로 관리함.

@RestController
public class BlogControllerTest {

    //http://localhost:8080/test/hello
    @GetMapping(value = "/test/hello")
    public String hello() {
       return "<h1>Hello Spring Boot</h1>";
    }
}
