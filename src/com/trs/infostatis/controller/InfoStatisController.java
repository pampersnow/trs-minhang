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
 *	创建日期：2018-09-6  9:45
 *	控制器说明：信息统计_控制器_实现前后台数据交互处理	
 */
@Controller
public class InfoStatisController {
	
	/**
	 * 注入service接口
	 * */    
	@Autowired
	private InfoStatisService infoStatisService;
	@Autowired
	private addInfoStatisService addInfoStatisService;
	
	/**
	 * 日志记录
	 * */
	private Logger logger = Logger.getLogger(InfoStatisController.class);
	
	/**
	 * 添加访问记录
	 * 前端页面Ajax发送请求调用该方法  
	 * */
	@RequestMapping(value="/doAddInfoCollect.html")	
	@ResponseBody
	 public  String  addInfoCollect(@RequestBody Info info ) throws Exception {		
		//日志打印
		logger.debug("=============addInfoCollect=======================");			
		System.out.println();
		addInfoStatisService.addInfo(info);
        System.out.println("OK");
        return "redirect:infostatis";
	 }
	
	/**
	 * 数据统计-获取周一至周日   每天访问量
	 * */
	@RequestMapping(value="/doInfoStatis.html")
	@ResponseBody
	public Object getInfoStatis() throws Exception {		
		//日志打印
		logger.debug("=================执行===getInfoStatis===================");
		List<Info> list=infoStatisService.queryDataStat();		
		Gson gson = new Gson();
		String json=gson.toJson(list);
		logger.info(json);
		return json;	
	} 
	
	/**
	 * 数据统计-获取周一至周日   每天发布量
	 * */
	@RequestMapping(value="/doPubCount.html")
	@ResponseBody
	public Object getPubCount() throws Exception {		
		//日志打印
		logger.debug("=================执行===getPubCount===================");
		List<Info> list=infoStatisService.queryPubCount();	
		Gson gson = new Gson();
		String json=gson.toJson(list);
		logger.info(json);
		return json;			
	}
	/**
	 * 起始日期查询访问量前五的记录数
	 * */
	@RequestMapping(value="/doStartEndInfo.html")
	public ModelAndView getStartEndInfo(@RequestParam(value="startTime",required=false)
										@DateTimeFormat(pattern="yyyy-MM-dd")Date startTime,
										@RequestParam(value="endTime",required=false)
										@DateTimeFormat(pattern="yyyy-MM-dd")Date endTime) throws Exception{
		logger.debug("=================执行===getStartEndInfo===================");
		ModelAndView mv = new ModelAndView();
		List<Info> list = infoStatisService.queryStartEndInfo(startTime, endTime);
		mv.addObject("list", list);
		mv.setViewName("infostatis");
		return mv;
	}	
		//测试页面跳转
		 @RequestMapping("3")  
		 public String msgTo3(){return "3"; }  
		//测试页面跳转
		 @RequestMapping("3/20180918_189414")  
		 public String msgToTit(){return "20180918_189414"; }  
}
