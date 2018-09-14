package com.trs.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.trs.dao.InfoStatisMapper;
import com.trs.pojo.Info;

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
	public List<Info> queryDataStat() throws Exception {
		// TODO Auto-generated method stub
			List<Info> list =infoStatisMapper.selectDataStat();   
			//if�ж�������ͨ��ǰ�ڲ���
			for (Info info : list) {
				if (info!=null) {
					System.out.println("===========info==============");
					System.out.println(info.getFWCount());
					System.out.println("=============================");
				} else {
					System.out.println("=======error info==============");
					System.out.println("error:info is null!");
					System.out.println("===============================");			
				}
			}			
		return list;
	}
	@Override
	public List<Info> queryStartEndInfo(Date startTime, Date endTime)
			throws Exception {
		// TODO Auto-generated method stub
		List<Info> list = infoStatisMapper.selectStartEndInfo(startTime, endTime);
		for (Info info : list) {
			//if�ж�������ͨ��ǰ�ڲ���
			if (info!=null) {
				System.out.println("===========info==============");
				System.out.println(info.getDOCTITLE());
				System.out.println(info.getDOCCLICKCOUNT());
				System.out.println(info.getDOCPUBTIME());
				System.out.println("=============================");
			} else {
				System.out.println("=======error info==============");
				System.out.println("error:info is null!");
				System.out.println("===============================");			
			}
		}
		return list;
	}
	@Override
	public List<Info> queryPubCount() throws Exception {
		// TODO Auto-generated method stub
		List<Info> list =infoStatisMapper.selectPubCount();
		//if�ж�������ͨ��ǰ�ڲ���
		for (Info info : list) {
			if (info!=null) {
				System.out.println("===========info==============");
				System.out.println(info.getFBCount());
				System.out.println("=============================");
			} else {
				System.out.println("=======error info==============");
				System.out.println("error:info is null!");
				System.out.println("===============================");			
			}
		}			
	return list;
	}
}
