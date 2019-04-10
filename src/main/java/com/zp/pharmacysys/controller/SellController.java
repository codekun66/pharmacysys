package com.zp.pharmacysys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zp.pharmacysys.service.SellService;

@Controller
public class SellController {

	@Autowired
	private SellService sellService;

	/*
	 * 增加销售订单信息接口
	 */
	@RequestMapping(value = "/sell/add" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSell(@RequestBody JSONObject jsonParam) throws Exception{
		System.out.println(jsonParam.toJSONString());
		int count = sellService.addSell(jsonParam);
		Map<String, Object> map = new HashMap<>();
		if(count > 0) {
			map.put("msg", "success");
			map.put("returnCode", 1);
			return map;
		}
		else {
			map.put("msg","error");
			map.put("returnCode", 0);
			return map;
		}
	}
	
/*	
	 * 获得所有销售订单信息接口
	 * @return
	 * 
	 */
	@RequestMapping(value="/sell/info" , method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getSellList() throws Exception{
		List<Map<String, Object>> list = sellService.getSellInfo();
		return list;
	}
}
