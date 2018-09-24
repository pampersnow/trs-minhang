package com.trs.infostatis.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
	public String getStatis() throws Exception {		
		//日志打印
		logger.debug("=================执行===getStatis===================");		
		List<Map> listClick=infoStatisService.queryDataStat();			
		List<Map> listPub=infoStatisService.queryPubCount();
		//日期集合
		Set<String> set = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = sdf.parse(o1);
					d2 = sdf.parse(o2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return d1.compareTo(d2);
			}
		});
		Map<String, String>  mapClick = new HashMap<String, String>();
		for (Map mapClickTmp : listClick) {
			String docclickdate = String.valueOf(mapClickTmp.get("docclickdate"));
			set.add(docclickdate);
			mapClick.put(docclickdate, String.valueOf(mapClickTmp.get("clickCount")));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> mapPub = new HashMap<String, String>();
		for (Map mapPubTmp : listPub) {
			String docpubtime = sdf.format(mapPubTmp.get("docpubtime"));
			set.add(docpubtime);
			mapPub.put(docpubtime, String.valueOf(mapPubTmp.get("pubCount")));
		}
		
		Object[] dateObjs = set.toArray();
		String[] dateStrs = new String[dateObjs.length] ;
		String[] clickStrs = new String[dateObjs.length] ;
		String[] pubStrs = new String[dateObjs.length] ;
		for (int i = 0;i<dateObjs.length;i++) {
			dateStrs[i]=String.valueOf(dateObjs[i]);
			clickStrs[i]=mapClick.get(dateStrs[i])==null?"0":mapClick.get(dateStrs[i]);
			pubStrs[i]=mapPub.get(dateStrs[i])==null?"0":mapPub.get(dateStrs[i]);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("dateStrs", dateStrs);
		jsonObject.put("clickStrs", clickStrs);
		jsonObject.put("pubStrs", pubStrs);
		logger.info("json:  "+jsonObject);
		return jsonObject.toString();	
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
		List<Map> list = infoStatisService.queryStartEndInfo(startTime, endTime);
		if (list==null && list.size()==0) {
			return "";
		}
		JSONArray jsonArray = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Map info : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("doctitle", info.get("DOCTITLE"));
			jsonObject.put("docpubtime",sdf.format(info.get("DOCPUBTIME")));
			jsonObject.put("docclickcount", info.get("DOCCLICKCOUNT"));
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
