package com.krry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.krry.entity.Country;
import com.krry.entity.Params;
import com.krry.service.ICountryService;

/**
 * KrryController
 * controller层，作为请求转发
 * @author asusaad
 *
 */
@Controller  //表示是多例模式，每个用户返回的web层是不一样的
@RequestMapping("/index")
public class KrryController {
	
	@Autowired
	private ICountryService countryService;
	
	/**
	 * 首页，并且分页查询
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(Params params){
		
		ModelAndView modelAndView = new ModelAndView();
		//一开始第一页，查询10条
		params.setPageNo(1);
		params.setPageSize(10);
		PageInfo<Country> pageInfo = countryService.finds(params);
		
		List<Country> clist = pageInfo.getList();

		//查询数量
		long couts = countryService.counts();

		modelAndView.addObject("clist", clist);
		modelAndView.addObject("couts", couts);
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	/**
	 * ajax请求 的 分页查询
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loadData")
	public HashMap<String, Object> loadData(Params params){
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageInfo<Country> pageInfo = countryService.finds(params);
		List<Country> clist = pageInfo.getList();
		map.put("clist", clist);
		
		return map;
	}
//	
	
}



