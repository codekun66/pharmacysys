package com.zp.pharmacysys.mapper;

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
}
