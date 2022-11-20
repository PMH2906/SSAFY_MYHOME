package com.ssafy.myhome.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.BaseAddress;
import com.ssafy.myhome.model.dto.HouseTrade;
import com.ssafy.myhome.model.mapper.InterestInfoMapper;

@Service
public class InterestInfoServiceImpl implements InterestInfoService {

	@Autowired
	InterestInfoMapper interestInfoMapper;
	
	@Override
	public boolean registInterestArea(Map<String, Object> map) throws Exception {
		return interestInfoMapper.registInterestArea(map)==1;
	}

	@Override
	public Page<BaseAddress> interestAreaSearch(String userid) throws Exception {
		return interestInfoMapper.interestAreaSearch(userid);
	}

	@Override
	public boolean registInterestTrade(Map<String, Object> map) throws Exception {
		return interestInfoMapper.registInterestTrade(map)==1;
	}

	@Override
	public Page<HouseTrade> interestTradeSearch(String userid) throws Exception {
		return interestInfoMapper.interestTradeSearch(userid);
	}

	@Override
	public boolean deleteInterestArea(String dongCode) throws Exception{
		return interestInfoMapper.deleteInterestArea(dongCode)==1;
	}

	@Override
	public boolean deleteInterestTrade(String tradeNo) throws Exception{
		return interestInfoMapper.deleteInterestTrade(tradeNo)==1;
	}

}
