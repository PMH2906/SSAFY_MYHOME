package com.ssafy.myhome.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.myhome.model.mapper.UserMapper;

@Configuration
//@MapperScan(
//		basePackages = "com.ssafy.myhome.model.mapper"
//)
@MapperScan(basePackageClasses = UserMapper.class)
public class DatabaseConfiguration {}