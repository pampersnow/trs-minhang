package com.trs.infostatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.exolab.castor.xml.Unmarshaller;

import com.trs.infra.config.domain.ConfigHelper;
import com.trs.infra.config.persistent.PluginConfig;
import com.trs.infra.persistent.db.ConnectPasswordEncrypter;

public class TrsDataSource extends BasicDataSource {
	private String configFile;
	private static Logger logger = Logger.getLogger(TrsDataSource.class);

	public void init() {
		try {
			Reader reader = Resources.getResourceAsReader(configFile);
			SAXReader localSAXReader = new SAXReader();
		    localSAXReader.setValidation(false);
		    Document localDocument = localSAXReader.read(reader);
		    Element rootElement = localDocument.getRootElement();
		    Element DBConnectionsElement = rootElement.element("extension").element("DBConnections");
		    String dbtype = DBConnectionsElement.attributeValue("default");
		    logger.debug("trs_TrsDataSource_29_dbtype="+dbtype);
		    Element dbElement = (Element)DBConnectionsElement.selectSingleNode("./DBConnect[@name='"+dbtype+"']");
		    if (dbElement==null) {
		    	logger.error("没有找到匹配的"+dbtype+"数据类型！");
		    }
		    String connectionURL = dbElement.attributeValue("connectionURL");
		    String connectionUser = dbElement.attributeValue("connectionUser");
		    String connectionPassword = dbElement.attributeValue("connectionPassword");
		    connectionPassword = ConnectPasswordEncrypter.deEncrypt(connectionPassword);
		    super.setUrl(connectionURL);
		    super.setUsername(connectionUser);
		    super.setPassword(connectionPassword);
			System.err.println("connectionURL:"+connectionURL+";connectionUser:"+connectionUser+";connectionPassword:"+connectionPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("TrsDataSource_9");
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}
}
