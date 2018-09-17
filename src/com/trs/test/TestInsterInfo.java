package com.trs.test;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;
import com.trs.dao.InfoStatisMapper;
import com.trs.pojo.Info;
/**
 * @author JYB
 *测试：插入数据
 */
public class TestInsterInfo {
	@Resource
	InfoStatisMapper infoStatisMapper;
	
	@Test
	public int testInsterInfo(Info info) throws Exception{
		Info in = new Info();
		in.setSTATISTICSID(13);
		in.setDOCID(13);
		in.setDOCTITLE("电子政务内网");
		in.setDOCCHANNEL(3);
		String DOCCLICKDATE="2018-09-18";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		//现将String转成Date
		date = sdf.parse(DOCCLICKDATE);
		in.setDOCCLICKDATE(date);
		int inf=infoStatisMapper.addInfoStatis(info);
		if (inf>0) {
			System.out.println("InsterInfo OK");
		} else {
			System.out.println("InsterInfo ON");
		}
		return inf;
	}
}
