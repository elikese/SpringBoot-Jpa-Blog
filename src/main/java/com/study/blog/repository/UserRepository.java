package com.study.blog.repository;

import com.study.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


// DAO임
// 자동으로 Bean등록이 됨 (@Repository 생략가능)
// JpaRopository<EntityClass, PK type>가 가지고 있는 여러 메서드 사용가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
