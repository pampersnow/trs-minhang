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
 *	创建日期：2018-09-6  9:45
 *	实现类说明：信息统计_业务逻辑实现类	
 */
@Service
public class InfoStatisServiceImpl implements InfoStatisService {

	@Resource
	private InfoStatisMapper infoStatisMapper;

	@Override  
	/**
	 * 查询点击量
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
	 * 查询发布量
	 */
	public List<Map> queryPubCount() throws Exception {
		List<Map> list =infoStatisMapper.selectPubCount();		
		return list;
	}
}
