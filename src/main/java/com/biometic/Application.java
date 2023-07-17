package com.biometic;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;



@ComponentScan(basePackages = "com.biometic")
@EnableJpaRepositories(basePackages = "com.biometic.repository")
@SpringBootApplication
@EnableScheduling
public class Application {
	public static void main(String[] args) {
		
		
		SpringApplication.run(Application.class, args);
	}

}
