package com.ssafy.myhome.model.service;

import com.ssafy.myhome.model.dto.User;

public interface UserService {
	public boolean signUp (User user)  throws Exception;
	public User login(User memberDto) throws Exception;
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userid) throws Exception;
	public void deleRefreshToken(String userid) throws Exception;
	public User userInfo(String userid) throws Exception; 
	
}
