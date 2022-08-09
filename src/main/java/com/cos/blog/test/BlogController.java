package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




//스프링은 특정 어노테이션이 붙어있는 클래스 파일들을 new해서(IoC) 스프링 컨테니ㅓ에 관래해줍니다
@RestController
public class BlogController {
	//http://localhost:8080/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>helloWorld</h1>"; 
	}

}
