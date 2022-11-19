package com.ssafy.myhome.model.service;

import java.util.Map;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.HouseTrade;

public interface AptTradeService {

	int houseTradeCnt(Map<String, Object> map) throws Exception;
	
	Page<HouseTrade> houseTradeSearch(Map<String, Object> map) throws Exception;

	boolean registHouseTrade(HouseTrade houseTrade) throws Exception;

	boolean registHousPeriodTrade(HouseTrade houseTrade) throws Exception;

	
}
