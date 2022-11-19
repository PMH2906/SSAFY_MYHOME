package com.ssafy.myhome.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.BaseAddress;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Housedeal;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.dto.SidoGugunDongCode;

public interface AptMapper {
	public Dongcode dongSearch(String dongCode) throws SQLException;;
	public Page<Houseinfo> houseInfoSearch(String dongCode) throws SQLException;
	public List<Housedeal> houseDealSearch(String aptCode) throws SQLException;
	public List<SidoGugunDongCode> getSido() throws SQLException;
	public List<SidoGugunDongCode> getGugun(String sidoCode) throws SQLException;
	public List<BaseAddress> getDong(String gugunCode) throws SQLException;
	
}
