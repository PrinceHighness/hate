/** 
 * <pre>项目名称:ssi-service-01 
 * 文件名称:MsgTask.java 
 * 包名:com.jk.task 
 * 创建日期:2017年8月1日上午8:51:13 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jk.pojo.user.UserRequest;
import com.jk.pojo.user.UserResponse;
import com.jk.service.user.UserService;

/** 
 * <pre>项目名称：ssi-service-01    
 * 类名称：MsgTask    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年8月1日 上午8:51:13    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年8月1日 上午8:51:13    
 * 修改备注：       
 * @version </pre>    
 */
@Component
public class MsgTask {
	
	@Resource
	private UserService userService;
	
	/*@Scheduled(cron = "0 17 9 * * ?")
	public void sayHello() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("你好，皮卡丘 >>" + sdf.format(new Date()));
	}
	
	@Scheduled(fixedRate = 3000, initialDelay = 5000)
	public void sendMsg() {
		UserRequest userRequest = new UserRequest();
		int selectUserCount = userService.selectUserCount(userRequest);
		userRequest.setTotalCount(selectUserCount);
		userRequest.calculate();
		List<UserResponse> selectUserList = userService.selectUserList(userRequest);
		for (UserResponse userResponse : selectUserList) {
			System.out.println(userResponse.getUserAccount());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("拿不到2万，没脸回家 >>" + sdf.format(new Date()));
	}*/

}
