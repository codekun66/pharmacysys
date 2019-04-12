package com.zp.pharmacysys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
		int count = sellService.addOneSell(jsonParam);
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
	
	/*
	 * 根据id获得销售订单信息接口
	 */
	 @RequestMapping(value = "/sellinfo/{id}", method = RequestMethod.GET)
	 public String getSellinfoById(@PathVariable("id") int id , ModelMap modelMap) throws Exception {  //@PathVariable用于定义自定义或动态请求URI
	   Map<String, Object> map = sellService.getSellInfoBySellId(id);
	   modelMap.addAttribute("sellinfo" , map);
	  return "print";
	 }
}
