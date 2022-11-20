package com.ssafy.myhome.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.BaseAddress;
import com.ssafy.myhome.model.dto.HouseTrade;

@Mapper
public interface InterestInfoMapper {

	int registInterestArea(Map<String, Object> map) throws SQLException;

	Page<BaseAddress> interestAreaSearch(String userid) throws SQLException;

	int registInterestTrade(Map<String, Object> map) throws SQLException;

	Page<HouseTrade> interestTradeSearch(String userid) throws SQLException;

	int deleteInterestArea(String dongCode) throws SQLException;

	int deleteInterestTrade(String tradeNo) throws SQLException;

}
