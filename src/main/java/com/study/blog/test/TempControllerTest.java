package com.study.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // REST랑 다르게 파일을 리턴
public class TempControllerTest {

    //http:localhost:8000/blog/temp/home
    @GetMapping(value = "/temp/home")
    public String tempHome() {
        // 파일 리턴 기본경로 : src/main/resource/static
        // 리턴파일 명 앞에 "/" 해줘야댐
        System.out.println("tempHome");
        return "/home.html";
    }

    @GetMapping(value = "/temp/img")
    public String tempImg() {
        System.out.println("이미지불러옴");
        return "/a.jpg";
    }

    @GetMapping(value = "/temp/jsp")
    public String tempJsp() {
        System.out.println("JSP불러옴");
        // Controller는 static에 있는 파일만 리턴함. 근데, jsp template는 동적파일이기때문에 static 폴더에 있지 못함.
        // 따라서 yml파일에 view에 대한 속성으로 prefix / suffix통해서 경로 만들어줌
        // prefix : /WEB-INF/views
        // 따라서 풀네임 -> /WEB-INF/views/test.jsp
        return "/test.jsp";
    }
}