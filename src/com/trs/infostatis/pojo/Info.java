package com.trs.infostatis.pojo;

import java.util.Date;

/**
 * @author JYB
 *	�������ڣ�2018-09-6  9:42
 *	ʵ����˵������Ϣͳ���ֶ����Է�װ	
 */
public class Info {                 
		 private  int	STATISTICSID; //����                 
		 private  int DOCID;		  //�ĵ�����           
		 private  String DOCTITLE;    //�ĵ�����         
		 private  int DOCCHANNEL;     //�ĵ�����Ƶ��     
		 private  Date DOCPUBTIME;    //�ĵ�����ʱ��     
		 private  Date DOCCLICKDATE;  //����ͳ�Ƶ����  
		 private  int DOCCLICKCOUNT;  //���ڵ������     
		 private Date startTime;      //��ʼʱ��
		 private Date endTime;        //����ʱ��
		 private int FWCount;         //������
		 private int FBCount;         //������
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
