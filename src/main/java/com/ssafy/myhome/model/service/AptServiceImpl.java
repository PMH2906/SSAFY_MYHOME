package com.ssafy.myhome.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.mapper.AptMapper;

@Service
public class AptServiceImpl implements AptService {

	@Autowired
	AptMapper aptMapper;
	
	@Override
	public Dongcode dongSearch(String dongCode) throws Exception {
		return aptMapper.dongSearch(dongCode);
	}

	@Override
	public Page<Houseinfo> houseInfoSearch(String dongCode) throws Exception {
		return aptMapper.houseInfoSearch(dongCode);
	}

}
