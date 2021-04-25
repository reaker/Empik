package com.example.empik.service;

import com.example.empik.dto.GithubUserDto;
import com.example.empik.dto.LoginDto;
import com.example.empik.model.Login;
import com.example.empik.repository.LoginRepository;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

	private static final String API_GITHUB_USERS = "https://api.github.com/users/";

	private LoginRepository loginRepository;

	@Autowired
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public LoginDto getUserInfo(String login) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.github.v3+json");

		HttpEntity<LoginDto> requestEntity = new HttpEntity<>(null, headers);
		GithubUserDto githubUserDto = restTemplate.exchange(new URI(API_GITHUB_USERS + login), HttpMethod.GET, requestEntity,
				GithubUserDto.class).getBody();

		Login loginDb = loginRepository.findByLogin(login);
		if (loginDb != null) {
			int requestCount = loginDb.getRequestCount();
			loginDb.setRequestCount(requestCount + 1);
			loginRepository.save(loginDb);
		} else {
			Login newLogin = new Login();
			newLogin.setLogin(githubUserDto.getLogin());
			newLogin.setRequestCount(1);
			loginRepository.save(newLogin);
		}

		LoginDto loginDto = new LoginDto();
		loginDto.setId(githubUserDto.getId());
		loginDto.setLogin(githubUserDto.getLogin());
		loginDto.setName(githubUserDto.getName());
		loginDto.setAvatarUrl(githubUserDto.getAvatarUrl());
		loginDto.setCreatedAt(githubUserDto.getCreatedAt());
		loginDto.setType(githubUserDto.getType());
		loginDto.setCalculations((6 / githubUserDto.getFollowers()) * (2 + githubUserDto.getPublicRepos()));

		return loginDto;
	}

}
