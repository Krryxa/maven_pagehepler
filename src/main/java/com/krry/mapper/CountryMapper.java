package com.krry.mapper;

import java.util.List;

import com.krry.entity.Country;

/**
 * 
 * Mapper：操作数据库
 * @author krry
 * @version 1.0.0
 *
 */
public interface CountryMapper {

	/**
	 * 查询
	 * @param params
	 * @return
	 */
	public List<Country> finds();
	
	/**
	 * 计算
	 * com.krry.dao.admin 
	 * 方法名：countBlogs
	 * @author krry 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public long counts();
	
	
}
