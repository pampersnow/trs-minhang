package com.trs.dao;
import java.util.List;
import com.trs.pojo.Info;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:40
 *	�ӿ�˵������Ϣͳ��	
 */
public interface InfoStatisMapper {
	
	//����ͳ��-��ѯ��һ������   ÿ���������������
	Info selectDataStat() throws Exception;
	
	//��ѯָ����ʼʱ���ڷ�����ǰ��ļ�¼
	List<Info> selectStartEndInfo() throws Exception;
	
	//���ͳ������
	int addInfoStatis(Info info)throws Exception;
}
