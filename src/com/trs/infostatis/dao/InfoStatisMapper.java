package com.trs.infostatis.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.trs.infostatis.pojo.Info;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:40
 *	�ӿ�˵������Ϣͳ��	
 */
public interface InfoStatisMapper {	
	//����ͳ��-��ѯ��һ������   ÿ������� 
	List<Map> selectDataStat() throws Exception;
	
	//����ͳ��-��ѯ��һ������   ÿ�췢����
	List<Map> selectPubCount() throws Exception;
	
	//��ѯָ����ʼʱ���ڷ�����ǰ��ļ�¼
	List<Map> selectStartEndInfo(@Param("startTime") Date startTime,
				@Param("endTime") Date endTime) throws Exception;
	
	//���ͳ������
	int addInfoStatis(Info info)throws Exception;
}
