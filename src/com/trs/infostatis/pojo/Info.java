package com.trs.infostatis.pojo;
import java.util.Date;
import trs.springframework.format.annotation.DateTimeFormat;
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
		 public Integer getFWCount() {
			return FWCount;
		}
		public void setFWCount(Integer fWCount) {
			FWCount = fWCount;
		}
		public Integer getFBCount() {
			return FBCount;
		}
		public void setFBCount(Integer fBCount) {
			FBCount = fBCount;
		}
		private Integer FWCount;         //������
		 private Integer FBCount;         //������
		 private  String daystr;
		 private  String daystr2;
		 private String Fwtimes;

		public String getFwtimes() {
			return Fwtimes;
		}
		public void setFwtimes(String fwtimes) {
			Fwtimes = fwtimes;
		}
		public String getDaystr2() {
			return daystr2;
		}
		public void setDaystr2(String daystr2) {
			this.daystr2 = daystr2;
		}
		public String getDaystr() {
			return daystr;
		}
		public void setDaystr(String daystr) {
			this.daystr = daystr;
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
		@DateTimeFormat(pattern="yyyy-MM-dd")
		public Date getDOCPUBTIME() {
			return DOCPUBTIME;
		}
		public void setDOCPUBTIME(Date dOCPUBTIME) {
			DOCPUBTIME = dOCPUBTIME;
		}
		@DateTimeFormat(pattern="yyyy-MM-dd")
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
