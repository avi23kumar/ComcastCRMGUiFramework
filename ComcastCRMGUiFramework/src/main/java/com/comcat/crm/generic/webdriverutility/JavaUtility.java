package com.comcat.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int ranDomNumber = random.nextInt(5000);
		return ranDomNumber;
	}
	
	public String getSystemDateYYYYMMDD() {
		Date dateobj =new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;
	}
	 
	public String getRequiredDateYYYDDMM(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}
}
