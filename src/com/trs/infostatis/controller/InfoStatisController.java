package com.trs.infostatis.controller;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.trs.infostatis.pojo.Info;
import com.trs.infostatis.service.InfoStatisService;
import com.trs.infostatis.service.addInfoStatisService;

import trs.springframework.beans.factory.annotation.Autowired;
import trs.springframework.format.annotation.DateTimeFormat;
import trs.springframework.stereotype.Controller;
import trs.springframework.web.bind.annotation.RequestBody;
import trs.springframework.web.bind.annotation.RequestMapping;
import trs.springframework.web.bind.annotation.RequestParam;
import trs.springframework.web.bind.annotation.ResponseBody;
import trs.springframework.web.servlet.ModelAndView;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:45
 *	������˵������Ϣͳ��_������_ʵ��ǰ��̨���ݽ�������	
 */
@Controller
public class InfoStatisController {
	
	/**
	 * ע��service�ӿ�
	 * */    
	@Autowired
	private InfoStatisService infoStatisService;
	@Autowired
	private addInfoStatisService addInfoStatisService;
	
	/**
	 * ��־��¼
	 * */
	private Logger logger = Logger.getLogger(InfoStatisController.class);
	
	/**
	 * ��ӷ��ʼ�¼
	 * ǰ��ҳ��Ajax����������ø÷���  
	 * */
	@RequestMapping(value="/doAddInfoCollect.html")	
	@ResponseBody
	 public  String  addInfoCollect(@RequestBody Info info ) throws Exception {		
		//��־��ӡ
		logger.debug("=============addInfoCollect=======================");			
		System.out.println();
		addInfoStatisService.addInfo(info);
        System.out.println("OK");
        return "redirect:infostatis";
	 }
	
	/**
	 * ����ͳ��-��ȡ��һ������   ÿ�������
	 * */
	@RequestMapping(value="/doInfoStatis.html")
	@ResponseBody
	public Object getInfoStatis() throws Exception {		
		//��־��ӡ
		logger.debug("=================ִ��===getInfoStatis===================");
		List<Info> list=infoStatisService.queryDataStat();		
		Gson gson = new Gson();
		String json=gson.toJson(list);
		logger.info(json);
		return json;	
	} 
	
	/**
	 * ����ͳ��-��ȡ��һ������   ÿ�췢����
	 * */
	@RequestMapping(value="/doPubCount.html")
	@ResponseBody
	public Object getPubCount() throws Exception {		
		//��־��ӡ
		logger.debug("=================ִ��===getPubCount===================");
		List<Info> list=infoStatisService.queryPubCount();	
		Gson gson = new Gson();
		String json=gson.toJson(list);
		logger.info(json);
		return json;			
	}
	/**
	 * ��ʼ���ڲ�ѯ������ǰ��ļ�¼��
	 * */
	@RequestMapping(value="/doStartEndInfo.html")
	public ModelAndView getStartEndInfo(@RequestParam(value="startTime",required=false)
										@DateTimeFormat(pattern="yyyy-MM-dd")Date startTime,
										@RequestParam(value="endTime",required=false)
										@DateTimeFormat(pattern="yyyy-MM-dd")Date endTime) throws Exception{
		logger.debug("=================ִ��===getStartEndInfo===================");
		ModelAndView mv = new ModelAndView();
		List<Info> list = infoStatisService.queryStartEndInfo(startTime, endTime);
		mv.addObject("list", list);
		mv.setViewName("infostatis");
		return mv;
	}	
		//����ҳ����ת
		 @RequestMapping("3")  
		 public String msgTo3(){return "3"; }  
		//����ҳ����ת
		 @RequestMapping("3/20180918_189414")  
		 public String msgToTit(){return "20180918_189414"; }  
}
