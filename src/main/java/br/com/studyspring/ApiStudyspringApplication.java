package br.com.studyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ApiStudyspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStudyspringApplication.class, args);
	}

}
