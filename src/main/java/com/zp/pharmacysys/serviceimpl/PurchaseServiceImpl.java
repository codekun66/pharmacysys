package com.zp.pharmacysys.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.mapper.PurchaseMapper;
import com.zp.pharmacysys.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseMapper purchaseMapper;
	
	@Override
	public List<Map<String, Object>> getPurchaseInfo() throws Exception {
		// TODO Auto-generated method stub
		return purchaseMapper.queryPurchaseInfo();
	}

	@Override
	public Map<String, Object> getPurchaseInfoById(int id) throws Exception {
		// TODO Auto-generated method stub
		return purchaseMapper.queryPurchaseInfoById(id);
	}

}
