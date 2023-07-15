package com.ar.bankingonline.api.dto;

import lombok.*;

import java.util.List;

@Data
public class UserDto {

	public UserDto(){}

	private Long id;

	private String username;

	private String password;

	private List<Long> idAccounts;

}
