package com.example.empik.controller;

import com.example.empik.dto.LoginDto;
import com.example.empik.service.LoginService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("users/{login}")
	public ResponseEntity<LoginDto> getUser(@PathVariable("login") String login) throws URISyntaxException {
		return new ResponseEntity<>(loginService.getUserInfo(login), HttpStatus.OK);
	}

}
