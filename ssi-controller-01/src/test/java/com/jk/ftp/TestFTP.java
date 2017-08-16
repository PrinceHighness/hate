/** 
 * <pre>项目名称:ssi-controller-01 
 * 文件名称:TestFTP.java 
 * 包名:com.jk.ftp 
 * 创建日期:2017年8月1日下午4:33:49 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

/** 
 * <pre>项目名称：ssi-controller-01    
 * 类名称：TestFTP    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年8月1日 下午4:33:49    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年8月1日 下午4:33:49    
 * 修改备注：       
 * @version </pre>    
 */
public class TestFTP {
	
	@Test
	public void connFTP() {
		//1、实例化客户端
		FTPClient ftp = new FTPClient();
		try {
			//2、连接ftp服务器
			ftp.connect("192.168.1.155", 21);
			//3、登陆ftp服务器
			boolean login = ftp.login("root", "root");
			if (login) {
				//4、切换到根路径(/)下
				ftp.changeWorkingDirectory("/");
				//4、1切换到/chengp/aaa下
				boolean boo1 = ftp.changeWorkingDirectory("chengp/aaa");
				if (!boo1) {
					//创建路径
					ftp.makeDirectory("chengp/aaa");
				}
				
				//如果上传媒体文件，需要设置二进制
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
				
				InputStream f = new FileInputStream("f:/1702A-test.txt");
				//5、向ftp上传文件
				boolean storeFile = ftp.storeFile(new String("九阴真经.txt".getBytes("GBK"), "ISO-8859-1"), f);
				System.out.println(storeFile);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
