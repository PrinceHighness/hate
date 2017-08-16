/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserResponse.java 
 * 包名:com.jk.pojo.user 
 * 创建日期:2017年7月17日上午11:00:42 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.pojo.user;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：UserResponse    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午11:00:42    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午11:00:42    
 * 修改备注：       
 * @version </pre>    
 */
public class UserResponse extends User {
	
	private long loginFailDate;

	public long getLoginFailDate() {
		return loginFailDate;
	}

	public void setLoginFailDate(long loginFailDate) {
		this.loginFailDate = loginFailDate;
	}

}
