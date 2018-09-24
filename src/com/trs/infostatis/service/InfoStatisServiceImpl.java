package com.trs.infostatis.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.trs.infostatis.dao.InfoStatisMapper;
import com.trs.infostatis.pojo.Info;

import trs.springframework.stereotype.Service;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:45
 *	ʵ����˵������Ϣͳ��_ҵ���߼�ʵ����	
 */
@Service
public class InfoStatisServiceImpl implements InfoStatisService {

	@Resource
	private InfoStatisMapper infoStatisMapper;

	@Override  
	/**
	 * ��ѯ�����
	 */
	public List<Map> queryDataStat() throws Exception {
			List<Map> list =infoStatisMapper.selectDataStat();   
		return list;
	}
	@Override
	public List<Map> queryStartEndInfo(Date startTime, Date endTime)
			throws Exception {
		List<Map> list = infoStatisMapper.selectStartEndInfo(startTime, endTime);
		return list;
	}
	@Override
	/**
	 * ��ѯ������
	 */
	public List<Map> queryPubCount() throws Exception {
		List<Map> list =infoStatisMapper.selectPubCount();		
		return list;
	}
}
