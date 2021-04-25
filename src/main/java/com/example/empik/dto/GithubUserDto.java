package com.example.empik.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class GithubUserDto implements Serializable {

	private static final long serialVersionUID = -1000513764701724173L;

	private Integer id;

	private String login;

	private String name;

	private String type;

	@JsonProperty("avatar_url")
	private String avatarUrl;

	private Float followers;

	@JsonProperty("public_repos")
	private Float publicRepos;

	@JsonProperty("created_at")
	private Date createdAt;

}
