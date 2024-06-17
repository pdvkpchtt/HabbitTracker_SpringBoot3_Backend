package com.example.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class FirstappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstappApplication.class, args);
 	}


	 @GetMapping("/")
	 public GreetResponse greet() {
		GreetResponse res = new GreetResponse(
				"Hello",
				List.of("JavaScript", "Python", "Java"),
				new Person("Danil", 21, 0.556)
		);

		return res;
	 }

	record Person(String name, int age, double savings) {

	}

	 record GreetResponse (String greet, List<String> favProgrammingLangs, Person person) {}

}
