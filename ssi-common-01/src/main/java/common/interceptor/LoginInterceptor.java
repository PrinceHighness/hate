/** 
 * <pre>项目名称:ssi-03 
 * 文件名称:LoginInterceptor.java 
 * 包名:common.interceptor 
 * 创建日期:2017年7月19日上午11:14:28 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;

import common.base.MySessionContext;

/** 
 * <pre>项目名称：ssi-03    
 * 类名称：LoginInterceptor    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月19日 上午11:14:28    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月19日 上午11:14:28    
 * 修改备注：       
 * @version </pre>    
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	/* (non-Javadoc)    
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)    
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取session对象
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		//获取访问的url
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		//获取访问参数
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//获取客户端主机
		String remoteHost = request.getRemoteHost();
		System.out.println(remoteHost);
		
		System.out.println("要想从此过，留下买路财");
//		System.out.println("#######################");
//		HttpSession session2 = MySessionContext.getSession("287");
//		if (null != session2) {
//			System.out.println(new Gson().toJson(session2));
//		}
//		System.out.println("#######################");
		
		//判断用户是否登陆过
		if (null != session.getAttribute("userInfo")) {
			//已登陆
			return true;
		} else {
			//未登录，重定向页面到登陆页面
			//判断是否是ajax请求
			
			String type = request.getHeader("X-Requested-With");// XMLHttpRequest
			// 重定向
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
			// 转发
			if (StringUtils.equals("XMLHttpRequest", type)) {
				// ajax请求
				response.setHeader("SESSIONSTATUS", "TIMEOUT");
				response.setHeader("CONTEXTPATH", basePath+"login.jsp");
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			} else {
				//常规
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		}
		// true:继续执行;false:返回前台
		return false;
	}

}
