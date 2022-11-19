package com.ssafy.myhome.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.HouseTrade;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.service.AptService;

@RestController
@RequestMapping("/apt")
public class AptController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	AptService service;
	
	@GetMapping("dongsearch/{dongCode}")
	public ResponseEntity<Dongcode> dongSearch(@PathVariable("dongCode") String dongCode) throws Exception{
		Dongcode dong = service.dongSearch(dongCode);
		return new ResponseEntity<Dongcode>(dong, HttpStatus.OK);
	}
	
	@Value("${paging.perpage}")
	int per;
	
	@GetMapping("houseInfosearch/{dongCode}")
	public  ResponseEntity<Map<String,Object>> houseInfoSearch(@RequestParam(required=false) Integer page, @PathVariable String dongCode) throws Exception{
		PageHelper.startPage(page =  page == null ? 1 : page, per);
		Page<Houseinfo> houseInfo = service.houseInfoSearch(dongCode);
		Map<String, Object> map = new HashMap<>();
		
		map.put("total",houseInfo.getTotal());
		map.put("per",houseInfo.getPageSize());
		map.put("current",houseInfo.getPageNum());
		map.put("list",houseInfo);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
