package com.study.blog.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터일때 사용
    private String content; // 섬머노트 라이브러리 사용할 예정<html> 태그가 섞여 디자인됨.

    @ColumnDefault("0")
    private int count; // 조회수

    // Many(Board) User(One) -> 한명의 유저는 여러 게시글이 있음
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId") // 실제로는 userId로 컬럼이 만들어짐.(FK생성)
    private User user; //DB는 객체저장이 불가능. 자바는 오브젝트 저장가능.

    // mappedBy -> 연관관계의 주인이 아니다(난 FK가 아니다) // DB에 컬럼을 만들지 마세요.
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> reply;

    @CreationTimestamp // DB에 입력되는 기준시간 기록
    private Timestamp createDate;


}
