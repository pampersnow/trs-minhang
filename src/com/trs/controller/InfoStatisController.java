package com.trs.controller;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.trs.pojo.Info;
import com.trs.service.InfoStatisService;

import trs.springframework.beans.factory.annotation.Autowired;
import trs.springframework.stereotype.Controller;
import trs.springframework.web.bind.annotation.RequestMapping;
import trs.springframework.web.bind.annotation.ResponseBody;
import trs.springframework.web.servlet.ModelAndView;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:45
 *	������˵������Ϣͳ��_������_ʵ��ǰ��̨���ݽ�������	
 */
@Controller
public class InfoStatisController {
	
	/*
	 * ע��service�ӿ�
	 * */
	@Autowired
	private InfoStatisService infoStatisService;
	
	/*
	 * ��־��¼
	 * */
	private Logger logger = Logger.getLogger(InfoStatisController.class);
	
	/*
	 * ����ͳ��-��ȡ��һ������   ÿ���������������
	 * */
	@RequestMapping(value="/doInfoStatis.html")
	@ResponseBody
	public Object getInfoStatis() throws Exception {		
		//��־��ӡ
		logger.debug("=================ִ��===getInfoStatis===================");
		Info info=infoStatisService.queryDataStat();
		if (info!=null) {
			System.out.println("===========info==============");
			System.out.println(info.getDOCCHANNEL());
			System.out.println(info.getDOCID());
			System.out.println("=============================");
		} else {
			System.out.println("=======error info==============");
			System.out.println("error:info is null!");
			System.out.println("===============================");			
		}
		Gson gson = new Gson();
		String json=gson.toJson(info);
		logger.info(json);
		return json;	
	} 
	
	
	/*
	 * ��ʼ���ڲ�ѯ������ǰ��ļ�¼��
	 * */
	@RequestMapping(value="/doStartEndInfo.html")
	public ModelAndView getStartEndInfo() throws Exception{
		logger.debug("=================ִ��===getStartEndInfo===================");
		ModelAndView mv = new ModelAndView();
		List<Info> list = infoStatisService.queryStartEndInfo();
		mv.addObject("list", list);
		mv.setViewName("infostatis");
		return mv;
	}
}
