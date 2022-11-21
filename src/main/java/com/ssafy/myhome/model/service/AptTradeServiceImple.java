package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.FileInfoDto;
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
		int success = aptTradeMapper.registHouseTrade(houseTrade);
		
		List<FileInfoDto> fileInfos = houseTrade.getFileInfos();
				
		if (fileInfos != null && !fileInfos.isEmpty()) {
			return success==1 &&aptTradeMapper.registerFile(houseTrade)==1;
		}
		return success==1;
	}

	@Override
	public boolean registHousPeriodTrade(HouseTrade houseTrade) throws Exception {
		int success = aptTradeMapper.registHousePeriodTrade(houseTrade);
		
		List<FileInfoDto> fileInfos = houseTrade.getFileInfos();
		
		if (fileInfos != null && !fileInfos.isEmpty()) {
			return success==1 && aptTradeMapper.registerFile(houseTrade)==1;
		}
		return success==1;
		
	}

	@Override
	public HouseTrade houseTrade(String tradeNo) throws Exception {
		return aptTradeMapper.houseTrade(tradeNo);
	}
	
}
