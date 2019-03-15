package com.zp.pharmacysys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.pharmacysys.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	
	/*
	 * 获取药品列表
	 * */
	@RequestMapping(value = "/goods/info")
	public String getGoodsList(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("goods" , goodsService.getGoodsList());
		return "goods";
	}
	
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public String getGoodsInfo(ModelMap modelMap)throws Exception{
		modelMap.addAttribute("goods" , goodsService.getGoodsList());
		return "goods";
	}
}
