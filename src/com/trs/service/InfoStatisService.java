package com.trs.service;

import java.util.List;

import com.trs.pojo.Info;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:45
 *	�ӿ�˵������Ϣͳ��_ҵ���߼��ӿ�	
 */
public interface InfoStatisService {
	
		Info queryDataStat() throws Exception;
		
		List<Info> queryStartEndInfo()throws Exception;
}
