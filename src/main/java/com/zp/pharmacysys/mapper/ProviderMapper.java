package com.zp.pharmacysys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zp.pharmacysys.bean.Provider;
/*
 *   供应商Mapper接口层
 * */
public interface ProviderMapper {

	/**
     * 查询所有供应商信息列表
     *
     * @return
     */
	List<Provider> queryProviderInfo();
	
	/**
     * 添加供应商信息
     *
     */
	int insertProvider(Provider provider);
	
	 /**
	  * 更新供应商信息
	  *
	  * @return
	  */
	int updateProvider(Map<String, Object> map); 
	
	/**
	 * 删除供应商信息
	 *
	 * @return
	 */
	int deleteProvider(@Param("id") int id);
}
