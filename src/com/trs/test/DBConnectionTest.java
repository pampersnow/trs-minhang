package com.trs.test;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.junit.Test;
import com.trs.dao.InfoStatisMapper;
import trs.springframework.context.ApplicationContext;
import trs.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author JYB
 *
 */
public class DBConnectionTest {
	
	@Resource
	InfoStatisMapper infoStatisMapper;
	@Test
	public void testDataSources() throws SQLException{
		 
		ApplicationContext ac = null;
		{
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		}
		DataSource dataSource=ac.getBean(DataSource.class);
		if (dataSource!=null) {   
			System.out.println("===================== OK Connection MySql  =====================");
			System.out.println("===================== OK Connection MySql =====================");
			System.out.println(dataSource.getConnection());
			System.out.println(dataSource.getLogWriter());
		} else {
			System.out.println(" NO Connection MySql");
			}		
		}
}
