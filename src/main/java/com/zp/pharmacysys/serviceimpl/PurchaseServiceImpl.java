package com.zp.pharmacysys.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.bean.Provider;
import com.zp.pharmacysys.bean.Purchase;
import com.zp.pharmacysys.mapper.GoodsMapper;
import com.zp.pharmacysys.mapper.ProviderMapper;
import com.zp.pharmacysys.mapper.PurchaseMapper;
import com.zp.pharmacysys.mapper.UserMapper;
import com.zp.pharmacysys.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	//使用mapper层提供的接口
	@Autowired
	private ProviderMapper providerMapper;
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<Map<String, Object>> getPurchaseInfo() throws Exception {
		List<Map<String, Object>> list =  purchaseMapper.queryPurchaseInfo();
		
		for (Map<String, Object> map : list) {
			int goodsId = (int) map.get("goods_id");
			int providerId = (int) map.get("provider_id");
			int userId = (int) map.get("user_id");
			String userName = userMapper.queryUsernameById(userId);
			map.put("userName", userName);
			Provider providerMap =  providerMapper.queryProviderInfoById(providerId);
			Map<String, Object>  goodsMap = (Map<String, Object>) goodsMapper.queryGoodsInfoById(goodsId);
			String goodsName = (String) goodsMap.get("name");
			map.put("goodsName", goodsName);
			String providerName = (String) providerMap.getName();
			map.put("providerName", providerName);
			String purchaseState = (String) map.get("state");
			if("0".equals(purchaseState)) {
				map.put("purchaseState","待审核" );
			} else if ("1".equals(purchaseState)) {
				map.put("purchaseState", "审核通过");
			}
		}
		
		return list;
	}

	@Override
	public Map<String, Object> getPurchaseInfoById(int id) throws Exception {
		Purchase purchase = purchaseMapper.queryPurchaseInfoById(id);
		int goodsId = purchase.getGoodsId();
		int providerId = purchase.getProviderId();
		Map<String, Object>  providerMap = (Map<String, Object>) providerMapper.queryProviderInfoById(providerId);
		Map<String, Object>  goodsMap = (Map<String, Object>) goodsMapper.queryGoodsInfoById(goodsId);
		String goodsName = (String) goodsMap.get("name");
		Map<String, Object>  map  = (Map<String, Object>) purchaseMapper.queryPurchaseInfoById(id);
		map.put("goodsName", goodsName);
		return map;
	}

	@Override
	public List<Map<String, Object>> getPurchaseNoState() throws Exception {
		List<Map<String, Object>> list =  purchaseMapper.queryPurchaseNoState();
		
		for (Map<String, Object> map : list) {
			int goodsId = (int) map.get("goods_id");
			int providerId = (int) map.get("provider_id");
			int userId = (int) map.get("user_id");
			String userName = userMapper.queryUsernameById(userId);
			map.put("userName", userName);
			Provider providerMap =  providerMapper.queryProviderInfoById(providerId);
			Map<String, Object>  goodsMap = (Map<String, Object>) goodsMapper.queryGoodsInfoById(goodsId);
			String goodsName = (String) goodsMap.get("name");
			map.put("goodsName", goodsName);
			String providerName = (String) providerMap.getName();
			map.put("providerName", providerName);
			String purchaseState = (String) map.get("state");
			if("0".equals(purchaseState)) {
				map.put("purchaseState","待审核" );
			} else if ("1".equals(purchaseState)) {
				map.put("purchaseState", "审核通过");
			}
		}
		
		return list;
	}

	@Override
	public int checkPurchaseById(int id) throws Exception {
		// TODO Auto-generated method stub
		return purchaseMapper.updatePurchaseState(id);
	}
	
	

}
