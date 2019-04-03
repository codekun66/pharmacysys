package com.zp.pharmacysys.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zp.pharmacysys.mapper.InventoryMapper;
import com.zp.pharmacysys.service.InventoryService;

public class InventoryServiceImpl  implements InventoryService{

	//使用mapper层提供的接口
	@Autowired
	private InventoryMapper inventoryMapper;
	
	@Override
	public int addInventory(Map<String, Object> map) throws Exception {
		return inventoryMapper.insertInventory(map);
	}

	@Override
	public Map<String, Object> getInventoryById(int id) {
		// TODO Auto-generated method stub
		return inventoryMapper.queryInventoryInfoById(id);
	}
 
	
}
