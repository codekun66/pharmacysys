package com.zp.pharmacysys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PurchaseMapper {
	
	/*
	 * 查询购物信息
	 * @return
	 * */
	List<Map<String,Object>> queryPurchaseInfo();
	
	/*
	 * 根据查询购物信息
	 * @return
	 * */
	Map<String,Object> queryPurchaseInfoById(@Param("id") int id);
	

}
