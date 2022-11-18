package com.ssafy.myhome.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.User;

@Mapper
public interface UserMapper {
	public int signUp (User user) throws SQLException;
	public User login(User user) throws SQLException;
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userid) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	public User userInfo(String userid) throws SQLException;
}
