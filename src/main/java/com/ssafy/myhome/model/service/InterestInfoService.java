package com.ssafy.myhome.model.service;

import java.util.Map;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.BaseAddress;
import com.ssafy.myhome.model.dto.HouseTrade;

public interface InterestInfoService {

	boolean registInterestArea(Map<String, Object> map) throws Exception;

	Page<BaseAddress> interestAreaSearch(String userid) throws Exception;

	boolean registInterestTrade(Map<String, Object> map) throws Exception;

	Page<HouseTrade> interestTradeSearch(String userid) throws Exception;

	boolean deleteInterestArea(String dongCode) throws Exception;

	boolean deleteInterestTrade(String tradeNo) throws Exception;

}
