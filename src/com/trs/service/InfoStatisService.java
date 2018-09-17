package com.trs.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.trs.pojo.Info;

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
		List<Info> queryDataStat() throws Exception;
		
		/**
<<<<<<< HEAD
		 * ��ѯһ���ڷ�����       
=======
		 * ��ѯһ���ڷ�����
>>>>>>> branch 'master' of https://github.com/ultralepton/trs-minhang.git
		 * @return 
		 * */
		List<Info> queryPubCount() throws Exception;
		
		/**
		 * ����ָ��ʱ���ѯ���±��⣬���ʴ���
		 * @return 
		 * */
		List<Info> queryStartEndInfo(@Param("startTime") Date startTime,@Param("endTime")Date endTime)throws Exception;
}
