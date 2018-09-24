package com.trs.infostatis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:45
 *	�ӿ�˵������Ϣͳ��_ҵ���߼��ӿ�	
 */
public interface InfoStatisService {
		/**
		 * ��ѯһ���ڷ�����
		 * @return   
		 * */
		List<Map> queryDataStat() throws Exception;
		
		/**
		 * ��ѯһ���ڷ�����       
		 * @return 
		 * */
		List<Map> queryPubCount() throws Exception;
		
		/**
		 * ����ָ��ʱ���ѯ���±��⣬���ʴ���
		 * @return 
		 * */
		List<Map> queryStartEndInfo(@Param("startTime") Date startTime,@Param("endTime")Date endTime)throws Exception;
}
