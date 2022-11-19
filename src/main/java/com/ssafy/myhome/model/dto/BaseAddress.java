package com.ssafy.myhome.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseAddress {
	private int no;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	private String lat;
	private String lng;
}