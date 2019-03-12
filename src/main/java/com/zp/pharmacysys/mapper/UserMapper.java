package com.zp.pharmacysys.mapper;

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

}
