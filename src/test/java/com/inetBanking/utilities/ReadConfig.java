package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch(Exception e){
			System.out.println("Exception is:"+ e.getMessage());
		}
	}
	public String getBrowserName() {
		String url = pro.getProperty("browser");
		return url;
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassord() {
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
