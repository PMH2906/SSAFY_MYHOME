package com.ssafy.myhome.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Housedeal;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.dto.SidoGugunDongCode;
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

	@Override
	public List<Housedeal> houseDealSearch(String aptCode) throws Exception {
		return aptMapper.houseDealSearch(aptCode);
	}

	@Override
	public List<SidoGugunDongCode> getSido() throws Exception {
		return aptMapper.getSido();
	}

	@Override
	public List<SidoGugunDongCode> getGugun(String sidoCode) throws Exception {
		return aptMapper.getGugun(sidoCode);
	}

	@Override
	public List<SidoGugunDongCode> getDong(String gugunCode) throws Exception {
		return aptMapper.getDong(gugunCode);
	}

}
