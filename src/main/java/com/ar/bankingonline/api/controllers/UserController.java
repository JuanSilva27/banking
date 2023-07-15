package com.ar.bankingonline.api.controllers;

import java.util.List;

import com.ar.bankingonline.api.dto.UserDto;
import com.ar.bankingonline.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService service;
	@Autowired

	public UserController(UserService service) {

		this.service = service;
	}


	//GET
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserDto>> getUser() {

		List<UserDto> usuarios = service.getUsers();

		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	};


	//GET USER

	@GetMapping(value = "/users/{id}")

	public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
	}

	// POST

	@PostMapping(value = "/user")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto){
		// Redirija hacia el responsable de crear un usuario en la DB
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(dto));

	}

	// PUT
	@PutMapping(value = "/user/{id}")

	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user){
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, user));
	}


	// DELETE

	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
	}
}
