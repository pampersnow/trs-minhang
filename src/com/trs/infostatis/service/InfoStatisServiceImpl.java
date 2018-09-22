package com.trs.infostatis.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public List<Info> queryDataStat() throws Exception {
		// TODO Auto-generated method stub
			List<Info> list =infoStatisMapper.selectDataStat();   
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			for (Info info : list) {
				info.setDaystr(formatter.format(info.getDOCCLICKDATE()));				
			}
		return list;
	}
	@Override
	public List<Info> queryStartEndInfo(Date startTime, Date endTime)
			throws Exception {
		// TODO Auto-generated method stub
		List<Info> list = infoStatisMapper.selectStartEndInfo(startTime, endTime);
		return list;
	}
	@Override
	public List<Info> queryPubCount() throws Exception {
		// TODO Auto-generated method stub
		List<Info> list =infoStatisMapper.selectPubCount();		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for (Info info : list) {
			info.setDaystr(formatter.format(info.getDOCPUBTIME()));
		}
		
		for (Info info : list) {
			if (info.getFBCount()==null) {
				info.setFBCount(0);
			}
		}
	return list;
	}
}
