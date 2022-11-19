package com.ssafy.myhome.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.HouseTrade;
import com.ssafy.myhome.model.mapper.AptTradeMapper;

@Service
public class AptTradeServiceImple implements AptTradeService {

	@Autowired
	AptTradeMapper aptTradeMapper;
	
	@Override
	public int houseTradeCnt(Map<String, Object> map) throws Exception {
		return aptTradeMapper.houseTradeCnt(map);
	}

	@Override
	public Page<HouseTrade> houseTradeSearch(Map<String, Object> map) throws Exception {
		return aptTradeMapper.houseTradeSearch(map);
	}

	@Override
	public boolean registHouseTrade(HouseTrade houseTrade) throws Exception {
		return aptTradeMapper.registHouseTrade(houseTrade)==1;
	}

	@Override
	public boolean registHousPeriodTrade(HouseTrade houseTrade) throws Exception {
		return aptTradeMapper.registHousePeriodTrade(houseTrade)==1;
	}
	
}
