package com.ssafy.myhome.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
	private String userId;
	private String userPass;
	private String userName;
	private String email;
	private String phone;
}