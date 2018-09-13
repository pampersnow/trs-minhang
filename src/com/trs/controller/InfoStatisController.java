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
 *	创建日期：2018-09-6  9:45
 *	控制器说明：信息统计_控制器_实现前后台数据交互处理	
 */
@Controller
public class InfoStatisController {
	
	/*
	 * 注入service接口
	 * */
	@Autowired
	private InfoStatisService infoStatisService;
	
	/*
	 * 日志记录
	 * */
	private Logger logger = Logger.getLogger(InfoStatisController.class);
	
	/*
	 * 数据统计-获取周一至周日   每天访问量，发稿量
	 * */
	@RequestMapping(value="/doInfoStatis.html")
	@ResponseBody
	public Object getInfoStatis() throws Exception {		
		//日志打印
		logger.debug("=================执行===getInfoStatis===================");
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
	 * 起始日期查询访问量前五的记录数
	 * */
	@RequestMapping(value="/doStartEndInfo.html")
	public ModelAndView getStartEndInfo() throws Exception{
		logger.debug("=================执行===getStartEndInfo===================");
		ModelAndView mv = new ModelAndView();
		List<Info> list = infoStatisService.queryStartEndInfo();
		mv.addObject("list", list);
		mv.setViewName("infostatis");
		return mv;
	}
}
