package com.krry.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.krry.entity.Country;
import com.krry.entity.Params;
import com.krry.mapper.CountryMapper;
import com.krry.service.ICountryService;

/**
 * 实现service层接口
 * @author asusaad
 *
 */
@Service
public class CountryService implements ICountryService{

	@Autowired
	private CountryMapper countryMapper;
	
	/**
	 * 查询
	 */
	public PageInfo<Country> finds(Params params) {
		
		//查询
		int pageNo = params.getPageNo();
		int pageSize = params.getPageSize();
		
		PageHelper.startPage(pageNo, pageSize);
        List<Country> blogs = countryMapper.finds();
        //用PageInfo对结果进行包装
        PageInfo<Country> pageInfo = new PageInfo<Country>(blogs);

        return pageInfo;
		
	}
	
	/**
	 * 计算
	 * @param params
	 * @return
	 */
	public long counts(){
		
		long couts = countryMapper.counts();
		
		return couts;
	}
	
	

}
