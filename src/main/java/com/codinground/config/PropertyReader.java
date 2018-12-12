package com.codinground.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.codinground.resourceHelper.ResourceHelper;

public class PropertyReader {
	
	public static Properties OR;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	static
	{
		
		OR = new Properties();
		//File confFile = new File();
		File confFile = new File(ResourceHelper.getBasePath()+"/src/main/properties files/conf.properties");
		
		FileInputStream confIstream;
		try {
			confIstream = new FileInputStream(confFile);
	
			OR.load(confIstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
