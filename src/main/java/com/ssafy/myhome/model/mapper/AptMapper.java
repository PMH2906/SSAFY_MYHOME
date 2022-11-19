package com.ssafy.myhome.model.mapper;

import java.sql.SQLException;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Houseinfo;

public interface AptMapper {
	Dongcode dongSearch(String dongCode) throws SQLException;;
	Page<Houseinfo> houseInfoSearch(String dongCode) throws SQLException;;
	
	
}
