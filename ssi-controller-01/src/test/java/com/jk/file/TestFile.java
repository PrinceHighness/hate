/** 
 * <pre>项目名称:ssi-controller-01 
 * 文件名称:TestFile.java 
 * 包名:com.jk.file 
 * 创建日期:2017年8月3日下午3:12:17 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

import org.junit.Test;

/** 
 * <pre>项目名称：ssi-controller-01    
 * 类名称：TestFile    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年8月3日 下午3:12:17    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年8月3日 下午3:12:17    
 * 修改备注：       
 * @version </pre>    
 */
public class TestFile {
	
	@Test
	public void getMD5() {
		String result = null;
		 try {
			 InputStream is = new FileInputStream("f:/B.txt");
			String type = "md5";
			 MessageDigest md = MessageDigest.getInstance(type);
			 byte[] buffer = new byte[8192];
			 int length = -1;
			 while ((length = is.read(buffer)) != -1) {
			     md.update(buffer, 0, length);
			 }
			 byte[] digest = md.digest();
			 StringBuffer strBuffer = new StringBuffer();
			  for (int i = 0; i < digest.length; i++) {
			   strBuffer.append(Integer.toHexString(0xff & digest[i]));
			  }
			  result = strBuffer.toString();
			  System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		   
		}
	}

}
