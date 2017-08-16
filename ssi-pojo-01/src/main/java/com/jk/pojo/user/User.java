/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:User.java 
 * 包名:com.jk.pojo.user 
 * 创建日期:2017年7月17日上午10:59:15 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.pojo.user;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

import common.util.Page;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：User    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午10:59:15    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午10:59:15    
 * 修改备注：       
 * @version </pre>    
 */
public class User extends Page implements Serializable {
	
	private int userID;
	
	private String userAccount;
	
	@Expose
	private String userPwd;
	
	private int loginFailNum;

	public int getLoginFailNum() {
		return loginFailNum;
	}

	public void setLoginFailNum(int loginFailNum) {
		this.loginFailNum = loginFailNum;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
