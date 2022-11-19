package com.ssafy.myhome.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.myhome.model.dto.HouseTrade;
import com.ssafy.myhome.model.service.AptTradeService;

@RestController
@RequestMapping("/apttrade")
public class AptTradeController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	AptTradeService service;
	
	@Value("${paging.perpage}")
	int per;
	
	@GetMapping("houseTradeCnt/{dongCode}/{jibun}")
	public ResponseEntity<Integer> houseTradeCnt(@RequestParam(required=false) Integer page, @RequestParam String dongCode, @RequestParam String jibun) throws Exception{
		int cnt = service.houseTradeCnt(dongCode, jibun);
		
		return new  ResponseEntity<Integer>(cnt,HttpStatus.OK);
	}
	
	@GetMapping("houseTradeSearch/{dongCode}/{jibun}")
	public  ResponseEntity<Map<String,Object>> houseTradeSearch(@RequestParam(required=false) Integer page,  @RequestParam String dongCode, @RequestParam String jibun) throws Exception{
		PageHelper.startPage(page =  page == null ? 1 : page, per);
		Page<HouseTrade> houseTrade = service.houseTradeSearch(dongCode, jibun);
		Map<String, Object> map = new HashMap<>();
		
		map.put("total",houseTrade.getTotal());
		map.put("per",houseTrade.getPageSize());
		map.put("current",houseTrade.getPageNum());
		map.put("list",houseTrade);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
