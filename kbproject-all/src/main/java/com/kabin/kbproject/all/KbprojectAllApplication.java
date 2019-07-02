package com.kabin.kbproject.all;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kabin.kbproject"})
@MapperScan("com.kabin.kbproject.db.dao")
public class KbprojectAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbprojectAllApplication.class, args);
	}

}
