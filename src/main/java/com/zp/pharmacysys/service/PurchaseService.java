package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.bean.Provider;
import com.zp.pharmacysys.bean.Purchase;
import com.zp.pharmacysys.mapper.PurchaseMapper;

@Service
public interface PurchaseService {
	
	/*
	 * 获得采购订单信息
	 * @return
	 * */
	List<Map<String, Object>> getPurchaseInfo() throws Exception;
	
	/*
	 * 根据id获取采购订单信息
	 * */
	Map<String, Object> getPurchaseInfoById(int id) throws Exception;


	/*
	 * 查询未审核采购订单信息
	 * */
	List<Map<String, Object>> getPurchaseNoState()  throws Exception ;
	
	
	 /*
	 * 审核通过采购订单信息
	 * */
	int checkPurchaseById(int id) throws Exception;
	
	/*
	 * 审核不通过通过采购订单信息
	 * */
	int notCheckPurchaseById(int id) throws Exception;
	
	/*
     * 添加采购订单信息
     *
     */
	int addPurchase(Map<String, Object> map) throws Exception;
	
}
