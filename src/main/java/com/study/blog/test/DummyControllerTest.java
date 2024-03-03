package com.study.blog.test;

import com.study.blog.model.RoleType;
import com.study.blog.model.User;
import com.study.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    // 의존성주입(DI) -
    @Autowired
    private UserRepository userRepository;


    // 다건 조회
    @GetMapping(value = "/dummy/users")
    public List<User> showUsersDetail() {
        return userRepository.findAll();
    }

    // 한 페이지당 2건에 데이터를 리턴받아 볼 예정(자동 페이지네이션)
    // http://localhost:8000/dummy/users/page?page=0 부터 1,2,3,4 ~
    @GetMapping(value = "/dummy/users/page")
    public List<User> showUserPageDetail(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        List<User> users = userRepository.findAll(pageable).getContent();
        return users;
    }

    // {id} 주소로 파라메터를 전달 받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping(value = "/dummy/user/{id}")
    public User showUserDetailById(@PathVariable int id) {
        // findById return값은 Optional Type임.
        // null check을 하여서 return해줘야 함 -> orElseGet으로 정상요청이면 User return, 이상요청이면 빈 User return
//        User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//            @Override
//            public User get() {
//                return new User();
//            }
//        });
//        return user;
        // 아래가 바로 권장하는 것!!
        User user = userRepository
                .findById(id)
                .orElseThrow(new Supplier<IllegalArgumentException>() {
                    @Override
                    public IllegalArgumentException get() {
                        return new IllegalArgumentException("해당유저는 없습니다. id:" + id);
                    }
                });

//                **람다식으로
//                .orElseThrow(() -> {
//                    return new IllegalArgumentException("해당사용자는 없습니다. id: " + id);
//                });
        // user 객체 -> 자바오브젝트. but, 요청은 web에서했고, RestController라서 data 리턴임.
        // web에 자바 객체를 던지는건데, 웹이 이해하기 편한걸로 던져줘야댐(JSON).
        // 이전에는 Gson을 썼었는데, 스프링부트는 MessageConverter가 응답시에 자동으로 작등하여,
        // Jackson 라이브러리 호출해서 자바객체를 JSON으로 변환해서 web으로 던져줌.
        return user;
    }


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
        System.out.println(user);

        user.setRole(RoleType.USER); // @ColumnDefault & @DynamicInsert 대신 Enum으로 지정해서 set해주자
        userRepository.save(user);
        return "회원가입 완료";
    }
    //    insert into
    //    User(crateDate, email, password, role, username)
    //    values(?, ?, ?, ?, ?)
    //     * createDate는 @CreationTimestamp가 insert당시 처리해줌
    //     * role에 null이 들어감 -> 쿼리에서 role을 없애야댐
    //       -> Entity Class에 @DynamicInsert 사용(null은 쿼리에서 제외해줌)

}