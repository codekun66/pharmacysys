package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;

public interface SellService {

	/*
     * 添加销售订单信息
     *
     */
	int addSell(Map<String, Object> map) throws Exception;
	/*
	 * 获得销售订单
	 * @return
	 * */
	List<Map<String, Object>> getSellInfo() throws Exception;
}
