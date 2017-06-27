package com.wyl.bihu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.wyl.bihu.Mapper")
public class BihuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BihuApplication.class, args);
	}
}
