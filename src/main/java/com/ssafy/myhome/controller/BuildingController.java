package com.ssafy.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.BuildingInfo;
import com.ssafy.myhome.model.dto.Dongcode;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.service.AptService;
import com.ssafy.myhome.model.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    BuildingService buildingService;
    
    @GetMapping("/{dongCode}")
    public ResponseEntity<List<BuildingInfo>> getBuildingInfo(@PathVariable("dongCode") String dongCode) throws Exception{
        List<BuildingInfo> list = buildingService.getBuildingInfo(dongCode);
        return new ResponseEntity<List<BuildingInfo>>(list, HttpStatus.OK);
    }
}