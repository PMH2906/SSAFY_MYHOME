package com.ssafy.myhome.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dto.BuildingInfo;
import com.ssafy.myhome.model.dto.Houseinfo;
import com.ssafy.myhome.model.mapper.BuildingMapper;

@Service
public class BuildingServiceImpl implements BuildingService{

    @Autowired
    BuildingMapper buildingmapper;

    @Override
    public List<BuildingInfo> getBuildingInfo(String dongCode) throws SQLException {
        return buildingmapper.getBuildingInfo(dongCode);
    }

}