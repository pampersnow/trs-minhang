package com.trs.service;

import java.util.List;

import com.trs.pojo.Info;

/**
 * @author JYB
 *	创建日期：2018-09-6  9:45
 *	接口说明：信息统计_业务逻辑接口	
 */
public interface InfoStatisService {
	
		Info queryDataStat() throws Exception;
		
		List<Info> queryStartEndInfo()throws Exception;
}
