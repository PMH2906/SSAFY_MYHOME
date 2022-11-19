package com.ssafy.myhome.model.service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.HouseTrade;

public interface AptTradeService {
	int houseTradeCnt(String dongCode, String jibun) throws Exception;

	Page<HouseTrade> houseTradeSearch(String dongCode, String jibun) throws Exception;
}
