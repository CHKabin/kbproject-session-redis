package com.kabin.kbproject.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kabin.kbproject.db"})
@MapperScan("com.kabin.kbproject.db.dao")
public class KbprojectDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbprojectDbApplication.class, args);
	}

}
