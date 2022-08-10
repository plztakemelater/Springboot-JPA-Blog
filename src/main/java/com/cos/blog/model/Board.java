package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터 
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인 됨
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = Board , User = One	, 한명의 유저는 여러개의 게시글을 작성할 수 있음	, OneToOne = 한명의 유저는 하나의 게시글만 작성 가능
	@JoinColumn(name="userId")
	private User user;	//DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy="board", fetch = FetchType.EAGER) // mappedBy = 연관관계의 주인이 아니다.(FK가 아니다) DB에 칼럼을 만들지 마시오
														  // fetch = FetchType.EAGER = 관련 정보를 항상 들고 와야 할 때 , LAZY = 관련 정보를 필요할 때만 들고올 때
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
