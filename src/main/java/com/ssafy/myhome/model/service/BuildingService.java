package com.ssafy.myhome.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myhome.model.dto.BuildingInfo;
import com.ssafy.myhome.model.dto.Houseinfo;

public interface BuildingService {
    List<BuildingInfo> getBuildingInfo(String dongCode) throws SQLException;
}