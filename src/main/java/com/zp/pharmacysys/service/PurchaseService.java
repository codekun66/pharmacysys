package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.mapper.PurchaseMapper;

@Service
public interface PurchaseService {
	
	/*
	 * 获取购买信息
	 * */
	List<Map<String,Object>> getPurchaseInfo() throws Exception;
	
	/*
	 * 根据id获取购买信息
	 * */
	Map<String,Object> getPurchaseInfoById(int id) throws Exception;

}
