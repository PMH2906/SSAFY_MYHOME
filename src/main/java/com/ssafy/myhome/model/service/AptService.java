package com.ssafy.myhome.model.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.BaseAddress;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Housedeal;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.dto.SidoGugunDongCode;


public interface AptService {

	BaseAddress dongSearch(String dongCode) throws Exception;

	Page<Houseinfo> houseInfoSearch(String dongCode) throws Exception;

	List<Housedeal>  houseDealSearch(String aptCode) throws Exception;

	List<SidoGugunDongCode> getSido() throws Exception;

	List<SidoGugunDongCode> getGugun(String sidoCode) throws Exception;

	List<BaseAddress> getDong(String gugunCode) throws Exception;

}
