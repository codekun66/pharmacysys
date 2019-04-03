package com.zp.pharmacysys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zp.pharmacysys.bean.Goods;
import com.zp.pharmacysys.bean.Provider;

/*
 * Goods Mapper接口层
 * */
public interface GoodsMapper {
	
	/*
	 * 查询所有药品信息
	 * @return
	 * */
	List<Map<String,Object>> queryGoodsInfo();
	
	/*
	 * 根据id查询药品信息
	 * @return
	 * */
	Map<String,Object> queryGoodsInfoById(@Param("id") int id);
	
	/*
	 * 添加药品信息
	 * @return
	 * */
	int insertGoods(Goods goods);
	
	/*
	 * 根据goodsCode查询药品id
	 * @return
	 * */
	int queryGoodsIdByCode (String code);
	
}
