package com.kabin.kbproject.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kabin.kbproject.db", "com.kabin.kbproject.main", "com.kabin.kbproject.common"})
@MapperScan("com.kabin.kbproject.db.dao")
public class KbprojectMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbprojectMainApplication.class, args);
	}

}
