package com.zp.pharmacysys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.pharmacysys.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	/*
	 * 获得所有库存信息列表接口
	 */
	@RequestMapping(value = "/inventory/info" , method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getInventoryList() throws Exception{
		return  inventoryService.getInventoryInfo();
	}
}
