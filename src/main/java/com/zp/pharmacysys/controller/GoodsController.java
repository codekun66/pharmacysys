package com.zp.pharmacysys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.pharmacysys.service.GoodsService;
import com.zp.pharmacysys.service.UserService;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	UserService userService;
	/*
	 * 获取药品列表
	 * */
	@RequestMapping(value = "/goods/info" , method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getGoodsList() throws Exception{
//		modelMap.addAttribute("goods" , goodsService.getGoodsList());
		return goodsService.getGoodsList();
	}
	
	@RequestMapping(value = "/goods/all", method = RequestMethod.GET)
	public String getGoodsInfo(ModelMap modelMap)throws Exception{
		modelMap.addAttribute("goods" , goodsService.getGoodsList());
		return "goods";
	}
}
