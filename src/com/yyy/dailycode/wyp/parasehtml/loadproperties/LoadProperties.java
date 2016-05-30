/**
 * 
 */
package com.yyy.dailycode.wyp.parasehtml.loadproperties;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * @author yangwensheng
 *
 */
public class LoadProperties {
	private static final Logger logger = Logger.getLogger(LoadProperties.class);
	/**
	 * @属性说明: log4j的路径
	 */
	private static final String LOG4JPATH = "resources.soundfile.httpconfig";
	private static ResourceBundle resouceBundle = null;
	public static ResourceBundle getResourceBundle(){
		if(resouceBundle == null){
			initLoadLog4JProperties();
		}
		return resouceBundle;
	}
	private static void initLoadLog4JProperties(){
		resouceBundle = ResourceBundle.getBundle(LOG4JPATH);
	}
	public static String getValue(String key){
		String value = null;
		try{
			value = getResourceBundle().getString(key);
		}catch (Exception e) {
			logger.error("获取配置文件值失败!", e);
		}
		return value;
	}
	public static void main(String[] args) {
		System.out.println(getValue("URL_ADDRESS"));
	}
}
