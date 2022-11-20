package com.ssafy.myhome.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.myhome.model.dto.BaseAddress;
import com.ssafy.myhome.model.dto.HouseTrade;
import com.ssafy.myhome.model.service.InterestInfoService;

@RestController
@RequestMapping("/interest")
public class InterestInfoController {
	private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    InterestInfoService interestInfoService;
    
    
    // 관심 지역 
	@PostMapping("/registarea")
	public ResponseEntity<String> registInterestArea(@RequestBody Map<String, Object> map) throws Exception {
		if(interestInfoService.registInterestArea(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	} 
    
	@Value("${paging.perpage}")
	int per;
	
	@GetMapping("/areasearch/{userid}")
	public  ResponseEntity<Map<String,Object>> interestAreaSearch(@RequestParam(required=false) Integer page, @PathVariable String userid ) throws Exception{
		PageHelper.startPage(page =  page == null ? 1 : page, per);
		
		Page<BaseAddress> houseTrade = interestInfoService.interestAreaSearch(userid);
		
		Map<String, Object> map = new HashMap<>();
		map.put("total",houseTrade.getTotal());
		map.put("per",houseTrade.getPageSize());
		map.put("current",houseTrade.getPageNum());
		map.put("list",houseTrade);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
    @DeleteMapping("/deletearea/{dongCode}")
	public ResponseEntity<String> deleteInterestArea(@PathVariable("dongCode") String dongCode) throws Exception{
		if(interestInfoService.deleteInterestArea(dongCode)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
   
    // 관심 매물  
    @PostMapping("/registtrade")
    public ResponseEntity<String> registInterestTrade(@RequestBody Map<String, Object> map) throws Exception {
    	if(interestInfoService.registInterestTrade(map)) {
    		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    } 
    
	@GetMapping("/tradesearch/{userid}")
	public  ResponseEntity<Map<String,Object>> interestTradeSearch(@RequestParam(required=false) Integer page, @PathVariable String userid ) throws Exception{
		PageHelper.startPage(page =  page == null ? 1 : page, per);
		
	
		Page<HouseTrade> houseTrade = interestInfoService.interestTradeSearch(userid);
		
		Map<String, Object> map = new HashMap<>();
		map.put("total",houseTrade.getTotal());
		map.put("per",houseTrade.getPageSize());
		map.put("current",houseTrade.getPageNum());
		map.put("list",houseTrade);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
    @DeleteMapping("/deletetrade/{tradeNo}")
	public ResponseEntity<String> deleteInterestTrade(@PathVariable("tradeNo") String tradeNo) throws Exception{
		if(interestInfoService.deleteInterestTrade(tradeNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
	
}
