package com.zp.pharmacysys.serviceimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JInternalFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.bean.Provider;
import com.zp.pharmacysys.bean.Purchase;
import com.zp.pharmacysys.mapper.GoodsMapper;
import com.zp.pharmacysys.mapper.InventoryMapper;
import com.zp.pharmacysys.mapper.ProviderMapper;
import com.zp.pharmacysys.mapper.PurchaseMapper;
import com.zp.pharmacysys.mapper.UserMapper;
import com.zp.pharmacysys.service.PurchaseService;
import com.zp.pharmacysys.util.OrderUtil;

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
	@Autowired
	private InventoryMapper inventoryMapper;
	
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
			} else if ("2".equals(purchaseState)) {
				map.put("purchaseState", "审核不通过");
			}
		}
		
		return list;
	}

	@Override
	public Map<String, Object> getPurchaseInfoById(int id) throws Exception {
		Map<String, Object> purchaseMap = purchaseMapper.queryPurchaseInfoById(id);
		int goodsId = (int) purchaseMap.get("goods_id");
		int providerId =(int) purchaseMap.get("provider_id");
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
	    Map<String, Object> map = purchaseMapper.queryPurchaseInfoById(id);
	    int goodsId = (int)map.get("goods_id");
		//查询该商品库存
		Map<String, Object> inventoryMap = inventoryMapper.queryInventoryInfoById(goodsId);
		//获得库存已有的数量
		int existCount = (int) inventoryMap.get("incount");
		Map<String, Object> updateInventoryMap = new HashMap<>();
		updateInventoryMap.put("goodsId", goodsId);
		//获取此次采购订单数量
        int count = (int) map.get("count");
        int totalCount = count+existCount ;
        BigDecimal x = new BigDecimal(totalCount); 
        updateInventoryMap.put("incount",totalCount );
        //进价
        BigDecimal unitprice = (BigDecimal) map.get("unitprice");
        updateInventoryMap.put("lastpurchaseprice", unitprice);
        //售价
        BigDecimal lastsellprice = (BigDecimal) inventoryMap.get("lastsellprice");
        //库存总值
        updateInventoryMap.put("inventorytotal",  unitprice.multiply(x) );
        //销售总值
        
        updateInventoryMap.put("selltotal", lastsellprice.multiply(x) );
        int updateInventory = inventoryMapper.updateInventory(updateInventoryMap);
		return purchaseMapper.updatePurchaseState(id);
	}

	@Override
	public int addPurchase(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		map.put("ordercode", OrderUtil.createOrder());
		int count = Integer.parseInt((String)map.get("count"));
		double unitprice = Double.parseDouble((String)map.get("unitprice"));
		map.put("totalprice", count*unitprice);
		//采购商品id
		return purchaseMapper.insertPurchase(map);
	}

	@Override
	public int notCheckPurchaseById(int id) throws Exception {
		// TODO Auto-generated method stub
		return purchaseMapper.updatePurchaseUnState(id);
	}
	
	
	
	

}
