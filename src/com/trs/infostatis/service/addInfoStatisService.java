package com.trs.infostatis.service;

import com.trs.infostatis.pojo.Info;


/**
 * @author JYB
 *	创建日期：2018-09-13  9:45
 *	接口说明：信息统计_业务逻辑接口_添加信息	
 */
public interface addInfoStatisService {
	/**
	 * 插入访客信息    
	 * @return         
	 * */
	boolean addInfo(Info info)throws Exception;
}
