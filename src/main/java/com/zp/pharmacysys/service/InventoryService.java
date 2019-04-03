package com.zp.pharmacysys.service;

import java.util.Map;


public interface InventoryService {

	/**
     * 添加库存信息
     *
     */
	int addInventory(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过Id获取库存信息
	 * 
	 * @return
	 */
	Map<String, Object> getInventoryById(int id);
}
