package com.ssafy.myhome.model.service;

import com.github.pagehelper.Page;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Houseinfo;


public interface AptService {

	Dongcode dongSearch(String dongCode) throws Exception;

	Page<Houseinfo> houseInfoSearch(String dongCode) throws Exception; 

}
