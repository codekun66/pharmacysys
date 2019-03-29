package com.zp.pharmacysys.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.bean.Provider;
import com.zp.pharmacysys.mapper.ProviderMapper;
import com.zp.pharmacysys.mapper.UserMapper;
import com.zp.pharmacysys.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	//使用mapper层提供的接口
		@Autowired
		private ProviderMapper providerMapper;
		@Autowired
		private UserMapper userMapper;
	
	@Override
	public List<Map<String, Object>> getProviderInfo() throws Exception {
		List<Map<String, Object>> list = providerMapper.queryProviderInfo();
		for (Map<String, Object> map : list) {
			int userId = (int) map.get("userId");
			String userName = userMapper.queryUsernameById(userId);
			map.put("userName", userName);
		}
		return list;
	}

	@Override
	public int addProvider(Provider provider)  throws Exception{
		// TODO Auto-generated method stub
		return providerMapper.insertProvider(provider);
	}

	@Override
	public int updateProviderById(Provider provider)  throws Exception{
		// TODO Auto-generated method stub
		return providerMapper.updateProvider(provider);
	}

	@Override
	public int deleteProviderById(int id) throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.deleteProvider(id);
	}

	@Override
	public Provider getProviderById(int id) {
		// TODO Auto-generated method stub
		return providerMapper.queryProviderInfoById(id);
	}

	
}
