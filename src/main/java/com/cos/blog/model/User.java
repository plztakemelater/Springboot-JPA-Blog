package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// ORM -> JAVA(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User클래스가 MYSQL에 테이블이 생성이 됨
@Data	
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체생성자
@Builder // 빌더 패턴
// @DynamicInsert = insert시에 null인 빌드를 제외시켜줌
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 프로젝트에서 연결된 DB의 넘버링 전략을 따라감
	private int id; // 시퀀스
	
	@Column(nullable = false, length = 30) // nullable=false = 널값이 되면 안되기에 사용함
	private String username;
	
	@Column(nullable = false, length = 100) // 비밀번호 값 크기를 크게 잡은 것은 암호화를 사용하기 위함 , ex)123456(비밀번호) -> 해쉬(비밀번호 암호화) 
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	
	//@ColumDefault("user")
	//DB는 RoleType이 없다
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는 것이 좋음 // ADMIN , USER
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
	
	
}
