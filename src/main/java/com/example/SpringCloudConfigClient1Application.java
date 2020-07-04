package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DbDetails;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringCloudConfigClient1Application {
	
	@Autowired
	private DbDetails dbDetails;
	
	@Value("${my.greetings}")
	private String greetings;
	
	@Value("${my.list.values}")
	private String list;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClient1Application.class, args);
	}
	
	@GetMapping(value = "/db")
	public DbDetails getDetails() {
		return dbDetails;
	}
	
	@GetMapping(value = "/greetings")
	public String greetings() {
		return greetings+list;
	}

}
