package com.study.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일) 하는 Controller -> @Controller

// 사용자가 요청 -> 응답(Data) : RestController
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest:";

    //http://localhost:8080/http/get (select)
    @GetMapping(value = "/http/get")
    public String getTest(Member member) {
        return "get 요청 : " + member.getId() + " " + member.getUsername() + " " + member.getPassword() + " " + member.getEmail();
    }


    //http://localhost:8080/http/post (insert)
    @PostMapping(value = "/http/post") // MessageConverter가 자동으로 요청데이터를 Mapping하여 객체로 만들어 줌
    public String postTest(@RequestBody Member member) {
        return "post 요청 : " + member.toString();
    }


    //http://localhost:8080/http/put (update)
    @PutMapping(value = "/http/put")
    public String putTest(@RequestBody Member member) {
        return "put 요청" + member.toString();
    }


    //http://localhost:8080/http/delete (delete)
    @DeleteMapping(value = "/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
    
}
