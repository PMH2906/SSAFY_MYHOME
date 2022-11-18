package com.ssafy.myhome.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dto.User;
import com.ssafy.myhome.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean signUp(User user) throws Exception {
		
		return userMapper.signUp(user)==1;
	}

	@Override
	public User login(User user) throws Exception {
		if(user.getUserId()==null || user.getUserPass()==null) return null;
		return userMapper.login(user);
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return userMapper.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token",null);
		userMapper.deleteRefreshToken(map);
		
	}

	@Override
	public User userInfo(String userid) throws Exception {
		return userMapper.userInfo(userid);
	}
	

}
