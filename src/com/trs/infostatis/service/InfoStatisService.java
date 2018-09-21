package com.trs.infostatis.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.trs.infostatis.pojo.Info;

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
		List<Info> queryDataStat() throws Exception;
		
		/**
		 * 查询一周内发稿量       
		 * @return 
		 * */
		List<Info> queryPubCount() throws Exception;
		
		/**
		 * 日期指定时间查询文章标题，访问次数
		 * @return 
		 * */
		List<Info> queryStartEndInfo(@Param("startTime") Date startTime,@Param("endTime")Date endTime)throws Exception;
}
