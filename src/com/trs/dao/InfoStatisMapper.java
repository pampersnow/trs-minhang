package com.trs.dao;
import java.util.List;
import com.trs.pojo.Info;

/**
 * @author JYB
 *	创建日期：2018-09-6  9:40
 *	接口说明：信息统计	
 */
public interface InfoStatisMapper {
	
	//数据统计-查询周一至周日   每天访问量，发稿量
	Info selectDataStat() throws Exception;
	
	//查询指定起始时间内访问量前五的记录
	List<Info> selectStartEndInfo() throws Exception;
	
	//添加统计数据
	int addInfoStatis(Info info)throws Exception;
}
