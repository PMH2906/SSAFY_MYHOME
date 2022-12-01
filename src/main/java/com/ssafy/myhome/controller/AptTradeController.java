package com.ssafy.myhome.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.myhome.model.dto.FileInfoDto;
import com.ssafy.myhome.model.dto.HouseTrade;
import com.ssafy.myhome.model.service.AptTradeService;

@RestController
@RequestMapping("/apttrade")
public class AptTradeController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	AptTradeService service;
	
	@Autowired
	ServletContext servletContext;
	@Value("${paging.perpage}")
	int per;
	
	@GetMapping("/houseTradeCnt")
	public ResponseEntity<Integer> houseTradeCnt(@RequestParam String dongCode, @RequestParam String jibun) throws Exception{
		System.out.print("cnt"+dongCode+"jibun"+jibun);
		
		Map<String, Object> map = new HashMap<>();
		map.put("dongCode", dongCode);
		map.put("jibun", jibun);
		int cnt = service.houseTradeCnt(map);
		
		return new ResponseEntity<Integer>(cnt,HttpStatus.OK);
	}
	
	@GetMapping("/houseTradeSearch")
	public  ResponseEntity<Map<String,Object>> houseTradeSearch(@RequestParam(required=false) Integer page,  @RequestParam String dongCode, @RequestParam String jibun) throws Exception{
		PageHelper.startPage(page =  page == null ? 1 : page, per);
		
		Map<String, Object> map = new HashMap<>();
		map.put("dongCode", dongCode);
		map.put("jibun", jibun);
		
		Page<HouseTrade> houseTrade = service.houseTradeSearch(map);
		map.clear();
		map.put("total",houseTrade.getTotal());
		map.put("per",houseTrade.getPageSize());
		map.put("current",houseTrade.getPageNum());
		map.put("list",houseTrade);
	
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@GetMapping("/houseTrade/{tradeNo}")
	public ResponseEntity<HouseTrade> houseTrade(@PathVariable String tradeNo) throws Exception{
		HouseTrade houseTrade = service.houseTrade(tradeNo);
		
		return new ResponseEntity<HouseTrade>(houseTrade,HttpStatus.OK);
	}

	//upfile: front에서 해당 이름으로 파일 리스트 보내주
	@PostMapping
	public ResponseEntity<String> registHouseTrade(@Value("${file.path.upload-images}") String filePath, @RequestPart("houseTrade") HouseTrade houseTrade, @RequestParam("upfile") MultipartFile[] files) throws Exception {

		System.out.println(houseTrade);
		System.out.println(files);
		if (!files[0].isEmpty()) {
//			String realPath = servletContext.getRealPath("/upload");
//			String realPath = servletContext.getRealPath("/resources/img");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
//			String saveFolder = realPath + File.separator + today;
			String saveFolder = filePath + File.separator + today;
			System.out.printf("저장 폴더 : %s", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				System.out.println("전 originalFileName "+originalFileName);
				
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginalFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				System.out.println("후  ");
				fileInfos.add(fileInfoDto);
			}
			houseTrade.setFileInfos(fileInfos);
			
		}
		
		if(!houseTrade.isTradeType()) { // 일반 매물 : tradeType : 0 
			if(service.registHouseTrade(houseTrade)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);			
		}else {
			if(service.registHousPeriodTrade(houseTrade)) { // 기간 매물 :tradeType :1
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);	
		}
		
	}
}
