package com.comcat.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonUtility {
	public String getDataFromJasonFile(String key) throws IOException, ParseException {
		FileReader file=new FileReader("./configAppData/commonData.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(file);
		
		JSONObject map=(JSONObject)obj;
		String data = (String)map.get(key);
		return data;
	}
}
