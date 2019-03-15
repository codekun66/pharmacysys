package com.zp.pharmacysys.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.bean.Goods;
import com.zp.pharmacysys.mapper.GoodsMapper;
import com.zp.pharmacysys.service.GoodsService;

/*
 * Goods业务接口实现层
 * */
@Service
public class GoodsServiceImpl implements GoodsService {
	
	//使用mapper层提供的接口
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Map<String, Object>> getGoodsList() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
		list = goodsMapper.queryGoodsInfo();
		return list;
	}

	@Override
	public Map<String, Object> getGoodsInfoById(int id) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map = goodsMapper.queryGoodsInfoById(id);
		return map;
	}

	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		try {
			return goodsMapper.insertGoods(goods);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
