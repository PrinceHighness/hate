/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserRequest.java 
 * 包名:com.jk.pojo.user 
 * 创建日期:2017年7月17日上午11:00:18 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.pojo.user;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：UserRequest    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午11:00:18    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午11:00:18    
 * 修改备注：       
 * @version </pre>    
 */
public class UserRequest extends User {
	
	private String userImgCode;
	
	private String sysImgCode;
	
	private int roleID;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getSysImgCode() {
		return sysImgCode;
	}

	public void setSysImgCode(String sysImgCode) {
		this.sysImgCode = sysImgCode;
	}

	public String getUserImgCode() {
		return userImgCode;
	}

	public void setUserImgCode(String userImgCode) {
		this.userImgCode = userImgCode;
	}

}
