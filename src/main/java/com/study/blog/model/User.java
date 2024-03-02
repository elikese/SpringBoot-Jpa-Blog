package com.study.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ORM -> JAVA 객체를 DB 테이블에 매핑해줌
@Entity // User 클래스가 MySQL 테이블이 생성이된다.
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // auto-increment

    @Column(nullable = false, length = 30)
    private String username; // ID

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; // Enum을 쓰는게 좋다 -> Domain을 정해서 사용할 수 있기 때문(자유도를 낮춤)

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp crateDate;
}
