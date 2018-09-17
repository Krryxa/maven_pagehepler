package com.krry.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.krry.entity.Country;
import com.krry.entity.Params;

/**
 * service层：处理业务逻辑（impl里面实现）
 * @author asusaad
 *
 */
public interface ICountryService {
	
	/**
	 * 分页查询所有博客
	 * @param params  分页参数 pageNo（页码），pageSize（每页查询数目）
	 * @return
	 */
	public PageInfo<Country> finds(Params params);
	
	/**
	 * 计算博客数量
	 * @param params
	 * @return
	 */
	public long counts();
	
}
