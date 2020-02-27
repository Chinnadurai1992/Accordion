package com.accordion.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager 
{
	public static ExtentReports extent;
    public synchronized static ExtentReports getReporter() 
    {
    	if(extent == null)
    	{
    		DateFormat dateformat = new SimpleDateFormat("yyyy_dd_MM_HH_mm_ss");
    		Date date= new Date();
    		String currentDate = dateformat.format(date);

    		ExtentHtmlReporter report=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/365Accordion"+currentDate+".html"));
    		extent=new ExtentReports();
    		extent.attachReporter(report); 
    	}
		return extent;
    }
	
}
