package com.zp.pharmacysys.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

/*
 *   库存 Mapper接口层
 * */

public interface InventoryMapper {

	/**
     * 添加库存信息
     *
     */
	int insertInventory(Map<String, Object> map);
	
	/**
	  * 更新库存信息
	  *
	  * @return
	  */
	int updateInventory(Map<String, Object> map); 
	
	/**
	 * 根据Id查询库存信息
	 *
	 * @return 
	 */
	Map<String, Object> queryInventoryInfoById(@Param("goodsId") int goodsId);
}
