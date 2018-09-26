package com.robot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 用pdf2htmlEX工具把pdf文件转成html
 * 
 */
public class Pdf2htmlEXUtil
{
	/**
	 * 调用pdf2htmlEX将pdf文件转换为html文件
	 * 
	 * @param pdfName
	 *            需要转换的pdf称
	 * 
	 * @param htmlName
	 *            生成的html名称
	 * 
	 * @return
	 * 
	 */
	public static boolean pdf2html(String pdfName, String htmlName)
	{

		Properties prop;
		try{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(Constant.CLASSES_PATH+Constant.URL_PROPERTIES_PATH);// 属性文件输入流
			prop.load(fis);// 将属性文件流装载到Properties对象中
			fis.close();// 关闭流
		} catch (FileNotFoundException e1){
			e1.printStackTrace();
			return false;
		} catch (IOException e1){
			e1.printStackTrace();
			return false;
		}

		String PDF2HtmlEX_HOME = prop.getProperty("PDF2HtmlEX_HOME");
		if (PDF2HtmlEX_HOME == null)
			return false;

		Runtime rt = Runtime.getRuntime();

		try{
	        Process p = rt.exec(PDF2HtmlEX_HOME +" --dest-dir "+Constant.PDF_TO_HTML_PATH+" " + Constant.OFFICE_TO_PDF_PATH + pdfName + " " + htmlName);

			StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");
			// kick off stderr
			errorGobbler.start();
			StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(), "STDOUT");
			// kick off stdout
			outGobbler.start();
			p.waitFor();
			//int w = p.waitFor();
			//System.out.println(w);
			p.exitValue();
			//int v = p.exitValue();
			//System.out.println(v);
			return true;
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
