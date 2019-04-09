package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;


public interface InventoryService {

	/**
     * 查询所有库存信息列表
     *
     * @return
     */
	List<Map<String, Object>> getInventoryInfo() throws Exception;
	
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
