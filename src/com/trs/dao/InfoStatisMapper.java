package com.trs.dao;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.trs.pojo.Info;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:40
 *	�ӿ�˵������Ϣͳ��	
 */
public interface InfoStatisMapper {
	
	//����ͳ��-��ѯ��һ������   ÿ������� 
	List<Info> selectDataStat() throws Exception;
	
	//����ͳ��-��ѯ��һ������   ÿ�췢����
	List<Info> selectPubCount() throws Exception;
	
	//��ѯָ����ʼʱ���ڷ�����ǰ��ļ�¼
	List<Info> selectStartEndInfo(@Param("startTime") Date startTime,
				@Param("endTime") Date endTime) throws Exception;
	
	//���ͳ������
	int addInfoStatis(Info info)throws Exception;
}
