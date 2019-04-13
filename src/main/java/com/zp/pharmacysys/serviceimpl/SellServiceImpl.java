package com.zp.pharmacysys.serviceimpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.mapper.GoodsMapper;
import com.zp.pharmacysys.mapper.InventoryMapper;
import com.zp.pharmacysys.mapper.SellMapper;
import com.zp.pharmacysys.mapper.UserMapper;
import com.zp.pharmacysys.service.SellService;
import com.zp.pharmacysys.util.OrderUtil;

@Service
public class SellServiceImpl implements SellService{

	@Autowired
	private SellMapper sellMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private InventoryMapper inventoryMapper;
	@Override
	public int addSell(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> sellMap = new HashMap<>();
		sellMap.put("ordercode", OrderUtil.createOrder());
		sellMap.put("userId", map.get("userId"));
		sellMap.put("remark", map.get("remark"));
		int insertSell = sellMapper.insertSell(sellMap);
		//查询销售订单id
		String ordercode = (String) sellMap.get("ordercode");
		int sellId = sellMapper.queryIdByOrderCode(ordercode);
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("selldetail");
		for (Map<String, Object> map2 : list) {
			map2.put("sellId", sellId);
			int goodsId = Integer.parseInt((String)map2.get("goodsId"));
			//查询该商品库存
			Map<String, Object> inventoryMap = inventoryMapper.queryInventoryInfoById(goodsId);
			//获得库存已有的数量
			int existCount = (int) inventoryMap.get("incount");
			Map<String, Object> updateInventoryMap = new HashMap<>();
			updateInventoryMap.put("goodsId", goodsId);
			//获取此次销售订单数量
			int count = Integer.parseInt((String)map2.get("count"));
			updateInventoryMap.put("sellcount",count );
			//获得表中原有的销售量
			int sellcount = (int) inventoryMap.get("sellcount");
			updateInventoryMap.put("sellcount",count+sellcount );
			
			int totalCount = existCount-count ;
			BigDecimal x = new BigDecimal(totalCount); 
	        updateInventoryMap.put("incount",totalCount );
	        //售价
	        
	        BigDecimal unitprice = new  BigDecimal((String) map2.get("unitprice"));
	        updateInventoryMap.put("lastsellprice", unitprice);
	        //进价
	        BigDecimal lastpurchaseprice = (BigDecimal) inventoryMap.get("lastpurchaseprice");
	        //库存总值
	        updateInventoryMap.put("inventorytotal",  lastpurchaseprice.multiply(x) );
	        //销售总值
	        updateInventoryMap.put("selltotal", unitprice.multiply(x) );
	        int updateInventory = inventoryMapper.updateInventory(updateInventoryMap);
		}
		return sellMapper.insertSellDetail(list);
	}
	
	@Override
	public int addOneSell(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		//入库sell
		Map<String, Object> sellMap = new HashMap<>();
		sellMap.put("ordercode", OrderUtil.createOrder());
		sellMap.put("userId", map.get("userId"));
		sellMap.put("remark", map.get("remark"));
		int insertSell = sellMapper.insertSell(sellMap);
		
		//入库sellDetail
		Map<String, Object> detailMap = new HashMap<>();
		detailMap.put("goodsId", map.get("goodsId"));
		//查询销售订单id
		String ordercode = (String) sellMap.get("ordercode");
		int sellId = sellMapper.queryIdByOrderCode(ordercode);
		detailMap.put("sellId", sellId);
		
		int goodsId = Integer.parseInt((String)map.get("goodsId"));
		//查询该商品库存
		Map<String, Object> inventoryMap = inventoryMapper.queryInventoryInfoById(goodsId);
		//获得库存已有的数量
		int existCount = (int) inventoryMap.get("incount");
		Map<String, Object> updateInventoryMap = new HashMap<>();
		updateInventoryMap.put("goodsId", goodsId);
		//获取此次销售订单数量
		int count = Integer.parseInt((String)map.get("count"));
		//获得表中原有的销售量
		int sellcount = (int) inventoryMap.get("sellcount");
		updateInventoryMap.put("sellcount",count+sellcount );
		detailMap.put("count", count);
		
		int totalCount = existCount-count ;
		BigDecimal x = new BigDecimal(totalCount); 
        updateInventoryMap.put("incount",totalCount );
        //售价
        
        BigDecimal unitprice = new  BigDecimal((String) map.get("unitprice"));
        updateInventoryMap.put("lastsellprice", unitprice);
        BigDecimal xcount = new BigDecimal(count);
        detailMap.put("unitprice", unitprice);
        //totalprice
        detailMap.put("totalprice", unitprice.multiply(xcount));
        //进价
        BigDecimal lastpurchaseprice = (BigDecimal) inventoryMap.get("lastpurchaseprice");
        //库存总值
        updateInventoryMap.put("inventorytotal",  lastpurchaseprice.multiply(x) );
        //销售总值
        updateInventoryMap.put("selltotal", unitprice.multiply(x) );
        int updateInventory = inventoryMapper.updateInventory(updateInventoryMap);
		
		return sellMapper.insertOnrSellDetail(detailMap);
	}



	@Override
	public List<Map<String, Object>> getSellInfo() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> sellList = sellMapper.querySellInfo();
		for (Map<String, Object> map : sellList) {
			int sellID = (int) map.get("id");
			int userId = (int) map.get("user_id");
			String userName = userMapper.queryUsernameById(userId);
			map.put("userName", userName);
			List<Map<String, Object>> sellDetailList = sellMapper.querySellDetailInfoById(sellID);
			map.put("sellCount", sellDetailList.size());
			double sellAmount = 0; 
			BigDecimal x = new BigDecimal(sellAmount);
			for (Map<String, Object> map2 : sellDetailList) {
				BigDecimal totalprice =  (BigDecimal) map2.get("totalprice");
				x = x.add(totalprice);
			}
			map.put("totalprice", x);
		}
		return sellList;
	}

	@Override
	public Map<String, Object> getSellInfoBySellId(int sellId) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> sellMap = sellMapper.querySellInfoById(sellId);
		List<Map<String, Object>> sellDetailList = sellMapper.querySellDetailInfoById(sellId);
		int userId = (int) sellMap.get("user_id");
		String username = userMapper.queryUsernameById(userId);
		sellMap.put("username", username);
		double sellAmount = 0; 
		BigDecimal x = new BigDecimal(sellAmount);
		for (Map<String, Object> map : sellDetailList) {
			int goodsId = (int) map.get("goods_id");
			Map<String, Object> goodsMap = goodsMapper.queryGoodsInfoById(goodsId);
			map.put("goodsName", goodsMap.get("name"));
			BigDecimal totalprice =  (BigDecimal) map.get("totalprice");
			x = x.add(totalprice);
		}
		sellMap.put("totalprice", x);
		sellMap.put("selldetail", sellDetailList);
		return sellMap;
	}

	
	
}
