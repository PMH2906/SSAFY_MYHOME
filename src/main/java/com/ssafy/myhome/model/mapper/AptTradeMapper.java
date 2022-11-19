package com.ssafy.myhome.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.HouseTrade;

public interface AptTradeMapper {

	public int registHouseTrade(HouseTrade houseTrade) throws SQLException;

	public int registHousePeriodTrade(HouseTrade houseTrade) throws SQLException;

	public int houseTradeCnt(Map<String, Object> map) throws SQLException;

	public Page<HouseTrade> houseTradeSearch(Map<String, Object> map) throws SQLException;

}
