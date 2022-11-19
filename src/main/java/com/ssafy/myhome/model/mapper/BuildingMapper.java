package com.ssafy.myhome.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.BuildingInfo;
import com.ssafy.myhome.model.dto.Houseinfo;

@Mapper
public interface BuildingMapper {
    List<BuildingInfo> getBuildingInfo(String dongCode) throws SQLException;
}