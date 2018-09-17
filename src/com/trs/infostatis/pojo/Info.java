package com.trs.infostatis.pojo;

import java.util.Date;

/**
 * @author JYB
 *	创建日期：2018-09-6  9:42
 *	实体类说明：信息统计字段属性封装	
 */
public class Info {                 
		 private  int	STATISTICSID; //主键                 
		 private  int DOCID;		  //文档主键           
		 private  String DOCTITLE;    //文档标题         
		 private  int DOCCHANNEL;     //文档所属频道     
		 private  Date DOCPUBTIME;    //文档发布时间     
		 private  Date DOCCLICKDATE;  //按天统计点击量  
		 private  int DOCCLICKCOUNT;  //日期点击次数     
		 private Date startTime;      //开始时间
		 private Date endTime;        //结束时间
		 private int FWCount;         //访问量
		 private int FBCount;         //发布量
		public int getFWCount() {
			return FWCount;
		}
		public void setFWCount(int fWCount) {
			FWCount = fWCount;
		}
		public int getFBCount() {
			return FBCount;
		}
		public void setFBCount(int fBCount) {
			FBCount = fBCount;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		public int getSTATISTICSID() {
			return STATISTICSID;
		}
		public void setSTATISTICSID(int sTATISTICSID) {
			STATISTICSID = sTATISTICSID;
		}
		public int getDOCID() {
			return DOCID;
		}
		public void setDOCID(int dOCID) {
			DOCID = dOCID;
		}
		public String getDOCTITLE() {
			return DOCTITLE;
		}
		public void setDOCTITLE(String dOCTITLE) {
			DOCTITLE = dOCTITLE;
		}
		public int getDOCCHANNEL() {
			return DOCCHANNEL;
		}
		public void setDOCCHANNEL(int dOCCHANNEL) {
			DOCCHANNEL = dOCCHANNEL;
		}
		public Date getDOCPUBTIME() {
			return DOCPUBTIME;
		}
		public void setDOCPUBTIME(Date dOCPUBTIME) {
			DOCPUBTIME = dOCPUBTIME;
		}
		public Date getDOCCLICKDATE() {
			return DOCCLICKDATE;
		}
		public void setDOCCLICKDATE(Date dOCCLICKDATE) {
			DOCCLICKDATE = dOCCLICKDATE;
		}
		public int getDOCCLICKCOUNT() {
			return DOCCLICKCOUNT;
		}
		public void setDOCCLICKCOUNT(int dOCCLICKCOUNT) {
			DOCCLICKCOUNT = dOCCLICKCOUNT;
		}
		@Override
		public String toString() {
			return "Info [STATISTICSID=" + STATISTICSID + ", DOCID=" + DOCID
					+ ", DOCTITLE=" + DOCTITLE + ", DOCCHANNEL=" + DOCCHANNEL
					+ ", DOCPUBTIME=" + DOCPUBTIME + ", DOCCLICKDATE="
					+ DOCCLICKDATE + ", DOCCLICKCOUNT=" + DOCCLICKCOUNT
					+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
		}
		public Info(int sTATISTICSID, int dOCID, String dOCTITLE,
				int dOCCHANNEL, Date dOCPUBTIME, Date dOCCLICKDATE,
				int dOCCLICKCOUNT, Date startTime, Date endTime) {
			super();
			STATISTICSID = sTATISTICSID;
			DOCID = dOCID;
			DOCTITLE = dOCTITLE;
			DOCCHANNEL = dOCCHANNEL;
			DOCPUBTIME = dOCPUBTIME;
			DOCCLICKDATE = dOCCLICKDATE;
			DOCCLICKCOUNT = dOCCLICKCOUNT;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public Info() {
			super();
			// TODO Auto-generated constructor stub
		}

}
