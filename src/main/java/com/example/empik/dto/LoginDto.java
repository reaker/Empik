package com.example.empik.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class LoginDto implements Serializable {

	private static final long serialVersionUID = -1000513764701724173L;

	private Integer id;

	private String login;

	private String name;

	private String type;

	private String avatarUrl;

	private Date createdAt;

	private Float calculations;

}
