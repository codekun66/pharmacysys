package com.zp.pharmacysys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zp.pharmacysys.bean.Purchase;

public interface PurchaseMapper {
	
	/*
	 * 查询采购订单信息
	 * @return
	 * */
	List<Map<String, Object>> queryPurchaseInfo();
	
	/*
	 * 根据id查询采购订单信息
	 * @return
	 * */
	Purchase queryPurchaseInfoById(@Param("id") int id);
	
	/*
	 * 审核采购订单
	 * @return
	 * */
	int updatePurchaseState(@Param("id") int id);

	/*
	 * 查询未审核采购订单信息
	 * @return
	 * */
	List<Map<String, Object>> queryPurchaseNoState();
}
