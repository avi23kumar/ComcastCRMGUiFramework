package com.comcat.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fls=new FileInputStream("./configAppData/commonData.properties");
		 Properties pobj=new Properties();
		 pobj.load(fls);
		 String data=pobj.getProperty(key);
		 return data;
	}
}
