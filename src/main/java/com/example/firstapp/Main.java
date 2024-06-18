package com.example.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
//@RequestMapping()
public class Main {

	private final UsersRepository usersRepository;

	public Main (UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
 	}


	 @GetMapping("/")
	 public String greet() {
		return "Hello";
	 }

	 @GetMapping("api/v1/users")
	 public List<Users> getUsers() {
		return usersRepository.findAll();
	 }

	 record NewUsersRequest (String name, String avatart) {

	 }

	 @PostMapping("api/v1/users")
	 public void addUser(@RequestBody NewUsersRequest request) {
		 Users users = new Users();
		 users.setName(request.name());
		 users.setAvatart(request.avatart());
		 usersRepository.save(users);
	 }

	 @DeleteMapping("api/v1/users/{userId}")
	 public void deleteUser(@PathVariable("userId") Integer id) {
		usersRepository.deleteById(id);
	 }

	 @PutMapping("api/v1/users/{userId}")
	 public void editUser(@RequestBody NewUsersRequest request, @PathVariable("userId") Integer id) {
		 Users users = usersRepository.findById(id).orElse(null);

		 if (users != null) {
			 users.setName(request.name());
			 users.setAvatart(request.avatart());
			 usersRepository.save(users);
		 }
	 }

}
