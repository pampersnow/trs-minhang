package com.trs.infostatis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author JYB
 *	创建日期：2018-09-6  9:45
 *	接口说明：信息统计_业务逻辑接口	
 */
public interface InfoStatisService {
		/**
		 * 查询一周内访问量
		 * @return   
		 * */
		List<Map> queryDataStat() throws Exception;
		
		/**
		 * 查询一周内发稿量       
		 * @return 
		 * */
		List<Map> queryPubCount() throws Exception;
		
		/**
		 * 日期指定时间查询文章标题，访问次数
		 * @return 
		 * */
		List<Map> queryStartEndInfo(@Param("startTime") Date startTime,@Param("endTime")Date endTime)throws Exception;
}
