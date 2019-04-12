package com.zp.pharmacysys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/*
 *   销售订单Mapper接口层
 * */
public interface SellMapper {

	/*
	 * 添加销售订单信息
	 * @return
	 * */
	int insertSell(Map<String, Object> map);
	
	/*
	 * 添加销售订单中商品信息
	 * @return
	 * */
	int insertSellDetail(List<Map<String,Object>> list);
	
	/*
	 * 根据销售订单ordercode查询id
	 * @return
	 * */
	int queryIdByOrderCode(@Param("ordercode") String ordercode );
	
	/*
	 * 查询销售订单信息
	 * @return
	 * */
	List<Map<String, Object>> querySellInfo();
	
	/*
	 * 查询销售订单明细信息
	 * @return
	 * */
	List<Map<String, Object>> querySellDetailInfoById(@Param("sellId") int sellId);
	
	/*
	 * 根据id返回销售订单信息
	 * @return
	 * */
	Map<String, Object> querySellInfoById(@Param("sellId") int sellId);
}
