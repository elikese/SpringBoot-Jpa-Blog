package com.study.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일) 하는 Controller -> @Controller

// 사용자가 요청 -> 응답(Data) : RestController
@RestController
public class HttpControllerTest {

    //http://localhost:8080/http/get (select)
    @GetMapping(value = "/http/get")
    public String getTest() {
        return "get 요청";
    }
    //http://localhost:8080/http/post (insert)
    @PostMapping(value = "/http/post")
    public String postTest() {
        return "post 요청";
    }
    //http://localhost:8080/http/put (update)
    @PutMapping(value = "/http/put")
    public String putTest() {
        return "put 요청";
    }
    //http://localhost:8080/http/delete (delete)
    @DeleteMapping(value = "/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
    
}
