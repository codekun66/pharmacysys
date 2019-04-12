package com.zp.pharmacysys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	/**
     * 获得密码
     * @param username 用户名
     */
    String queryPasswordByUsername(String username);
    
    /**
     * 获得角色类型
     * @param username 用户名
     * @return user/admin
     */
    String queryRoleByUsername(String username);
    
    /**
     * 获得用户id
     * @param username 用户名
     * @return user/admin
     */
    int queryUserId(String username);
    
    /**
     * 根据用户id获取用户姓名
     * @param id 用户名
     * @return username
     */
    String queryUsernameById (@Param("id") int id) ;
    
    
    /**
	 * 添加user信息
	 *
	 * @return
	 */
	int insertUser(Map<String, Object> map);
	
	/**
     * 查询所有角色
     *
     * @return
     */
	List<Map<String, Object>> queryRoleInfo();
}
