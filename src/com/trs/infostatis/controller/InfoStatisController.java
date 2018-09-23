package com.trs.infostatis.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

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
	public String addInfoCollect(@RequestBody String data) throws Exception {
		// 日志打印
		logger.debug("addInfoCollect:" + data);
		JSONObject jsonObject = new JSONObject(data);

		Info info = new Info();
		info.setDOCID(jsonObject.getInt("DOCID"));
		info.setDOCTITLE(jsonObject.getString("DOCTITLE"));
		info.setDOCCHANNEL(jsonObject.getInt("DOCCHANNEL"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		info.setDOCPUBTIME(sdf.parse(jsonObject.getString("DOCPUBTIME")));
		info.setDOCCLICKDATE(new Date());
		addInfoStatisService.addInfo(info);
		System.out.println("OK");
		return "add success!";
	}
	/**
	 * 数据统计-获取7天以内的访问量、发布量
	 * */
	@RequestMapping(value="/doStatis.html")
	@ResponseBody
	public Object getStatis() throws Exception {		
		//日志打印
		logger.debug("=================执行===getStatis===================");		
		List<Info> list=infoStatisService.queryDataStat();			
		List<Info> list2=infoStatisService.queryPubCount();
		////以访问时间作为key 
		Map<Object, Info> map = new HashMap<Object, Info>();
		for (Info info : list) { map.put(info.getDaystr(), info); }
		for (Info info : list2) {
			if (map.containsKey(info.getDaystr())) {
				//map.remove(info.getDaystr());//移除键值为发布时间相等的对象
				//map.put(info.getFBCount());
				map.containsValue(info.getFBCount());
				continue;//停止并返回继续循环
			} 
			map.put(info.getDaystr(), info);
		}
		 //循环map再对map中每个对象进行操作
		for (Entry<Object, Info> entry : map.entrySet()) {
			System.out.println("map:  key="+entry.getKey());
			System.out.println("map:  value="+entry.getValue());
		}
		JSONObject jsonObject = new JSONObject(map);
		logger.info("json:  "+jsonObject);
		return jsonObject;	
	}
	/**
	 * 起始日期查询访问量前五的记录数
	 * */
	@RequestMapping(value="/doStartEndInfo.html")
	@ResponseBody
	public String getStartEndInfo(@RequestParam(value="startTime",required=false)
										@DateTimeFormat(pattern="yyyy-MM-dd")Date startTime,
										@RequestParam(value="endTime",required=false)
										@DateTimeFormat(pattern="yyyy-MM-dd")Date endTime) throws Exception{
		logger.debug("startTime:"+startTime+";endTime:"+endTime);
		List<Info> list = infoStatisService.queryStartEndInfo(startTime, endTime);
		if (list==null && list.size()==0) {
			return "";
		}
		JSONArray jsonArray = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Info info : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("doctitle", info.getDOCTITLE());
			jsonObject.put("docpubtime",sdf.format(info.getDOCPUBTIME()));
			jsonObject.put("docclickcount", info.getDOCCLICKCOUNT());
			jsonArray.put(jsonObject);
		}
		
		return jsonArray.toString();
	}	
		//测试页面跳转
		 @RequestMapping("3")  
		 public String msgTo3(){return "3"; }  
		//测试页面跳转
		 @RequestMapping("3/20180918_189414")  
		 public String msgToTit(){return "20180918_189414"; }  
		//测试页面跳转
		 @RequestMapping("test")  
		 public String msgTest(){return "test"; }  
}
