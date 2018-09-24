package com.trs.infostatis.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.trs.infostatis.pojo.Info;

/**
 * @author JYB
 *	创建日期：2018-09-6  9:40
 *	接口说明：信息统计	
 */
public interface InfoStatisMapper {	
	//数据统计-查询周一至周日   每天访问量 
	List<Map> selectDataStat() throws Exception;
	
	//数据统计-查询周一至周日   每天发布量
	List<Map> selectPubCount() throws Exception;
	
	//查询指定起始时间内访问量前五的记录
	List<Map> selectStartEndInfo(@Param("startTime") Date startTime,
				@Param("endTime") Date endTime) throws Exception;
	
	//添加统计数据
	int addInfoStatis(Info info)throws Exception;
}
