package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zp.pharmacysys.bean.Goods;
import com.zp.pharmacysys.bean.Provider;

/*
 * 药品业务接口层
 * 
 * */
@Service
public interface GoodsService {
	
	/*
	 * 获取所有药品信息
	 * */
	List<Map<String,Object>> getGoodsList() throws Exception;
	
	/*
	 * 根据id获取药品信息
	 * 
	 * */
	Map<String,Object> getGoodsInfoById(int id) throws Exception;
	
	/*
	 * 添加药品
	 * */
	int addGoods(Goods goods)throws Exception;
	

}
