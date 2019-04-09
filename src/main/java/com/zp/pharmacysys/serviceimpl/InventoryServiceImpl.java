package com.zp.pharmacysys.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.mapper.GoodsMapper;
import com.zp.pharmacysys.mapper.InventoryMapper;
import com.zp.pharmacysys.service.InventoryService;
@Service
public class InventoryServiceImpl  implements InventoryService{

	//使用mapper层提供的接口
	@Autowired
	private InventoryMapper inventoryMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<Map<String, Object>> getInventoryInfo() throws Exception {
		List<Map<String, Object>> list  = inventoryMapper.queryInventoryInfo();
		for (Map<String, Object> map : list) {
			int goodsId = (int) map.get("goods_id");
			Map<String, Object>  goodsMap = (Map<String, Object>) goodsMapper.queryGoodsInfoById(goodsId);
			String goodsName = (String) goodsMap.get("name");
			String goodsCode = (String) goodsMap.get("code");
			String goodsType = (String) goodsMap.get("type");
			map.put("goodsName", goodsName);
			map.put("goodsCode", goodsCode);
			map.put("goodsType", goodsType);
		}
		return list;
	}

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
