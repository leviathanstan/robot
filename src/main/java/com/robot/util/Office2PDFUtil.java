package com.robot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Properties;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * 用OpenOffice将Office文档转换为PDF文档
 * 
 */
public class Office2PDFUtil {

	/**
	 * 将Office文档转换为PDF. 运行该函数需要用到OpenOffice
	 * 
	 * @param sourceFile 源文件名字
	 *            可以是Office2003-2007全部格式的文档, Office2010的没测试. 包括.doc,
	 *            .docx, .xls, .xlsx, .ppt, .pptx等.
	 * @param destFile	目标文件名字
	 * @return
	 */
	public static boolean office2PDF(String sourceFile, String destFile) {
		try {
			File inputFile = new File(Constant.OFFICE_PATH + sourceFile);

			// 如果目标路径不存在, 则新建该路径
			File outputFile = new File(Constant.OFFICE_TO_PDF_PATH + destFile);
			if (!outputFile.getParentFile().exists()) {
				outputFile.getParentFile().mkdirs();
			}
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constant.CLASSES_PATH+Constant.URL_PROPERTIES_PATH);// 属性文件输入流
			prop.load(fis);// 将属性文件流装载到Properties对象中
			fis.close();// 关闭流

			String OpenOffice_HOME = prop.getProperty("OpenOffice_HOME");
			// 启动OpenOffice的服务
			String command = OpenOffice_HOME + "soffice -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\" -nofirststartwizard";
			Process pro = Runtime.getRuntime().exec(command);

			// connect to an OpenOffice.org instance running on port 8100
			OpenOfficeConnection connection = new SocketOpenOfficeConnection(
					"127.0.0.1", 8100);
			connection.connect();

			// convert
			DocumentConverter converter = new OpenOfficeDocumentConverter(
					connection);
			converter.convert(inputFile, outputFile);

			// close the connection
			connection.disconnect();
			// 关闭OpenOffice服务的进程
			pro.destroy();

			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
}
