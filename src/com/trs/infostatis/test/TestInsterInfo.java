package com.trs.infostatis.test;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;

import com.trs.infostatis.dao.InfoStatisMapper;
import com.trs.infostatis.pojo.Info;
/**
 * @author JYB
 *���ԣ���������
 */
public class TestInsterInfo {
	@Resource
	InfoStatisMapper infoStatisMapper;
	
	@Test
	public int testInsterInfo() throws Exception{
		Info in = new Info();
		in.setSTATISTICSID(13);
		in.setDOCID(13);
		in.setDOCTITLE("������������");
		in.setDOCCHANNEL(3);
		String DOCCLICKDATE="2018-09-18";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		//�ֽ�Stringת��Date
		date = sdf.parse(DOCCLICKDATE);
		in.setDOCCLICKDATE(date);
		int inf=infoStatisMapper.addInfoStatis(in);
		if (inf>0) {
			System.out.println("InsterInfo OK");
		} else {
			System.out.println("InsterInfo ON");
		}
		return inf;
	}
}
