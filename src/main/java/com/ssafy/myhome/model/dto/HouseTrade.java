package com.ssafy.myhome.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HouseTrade {
	private int tradeNo;
	private String deposit;
	private String rentFee;
	private String managementFee;
	private boolean furnitureOpt;
	private boolean livingType;
	private boolean parkingOpt;
	private boolean petOpt;
	private boolean loanOpt;
	private boolean commissionOpt;
	private boolean insuranceOpt;
	private String userId;
	private String bcode;
	private String sido;
	private String sigungu;
	private String bname;
	private String buildingName;
	private String lat;
	private String lng;
	private String area;
	private String floor;
	private int buildYear;
	private boolean contractType;
	private String startDate;
	private String endDate;
	private int tradeType;
	private String jibun;
	
}