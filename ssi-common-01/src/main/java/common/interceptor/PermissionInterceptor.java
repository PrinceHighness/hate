/** 
 * <pre>项目名称:ssi-common-01 
 * 文件名称:PermissionInterceptor.java 
 * 包名:common.interceptor 
 * 创建日期:2017年7月28日上午9:38:32 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package common.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import common.util.JedisUtil;
import common.util.JsonUtil;

/** 
 * <pre>项目名称：ssi-common-01    
 * 类名称：PermissionInterceptor    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月28日 上午9:38:32    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月28日 上午9:38:32    
 * 修改备注：       
 * @version </pre>    
 */
public class PermissionInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)    
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)    
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)    
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	/* (non-Javadoc)    
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)    
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userInfo");
		String json = new Gson().toJson(obj);
		int userID = new JsonParser().parse(json).getAsJsonObject().get("userID").getAsInt();
		//获取用户的访问uri，与权限的url做对比，匹配上就向后执行，匹配不上，重定向到无权限页面
		String uri = request.getRequestURI();
		//取出redis中保存的菜单列表
		String string = JedisUtil.getString(userID + "#tree_list");
		
		int flag = 0;
		//List<Map<String, Object>>
		List<Map<String, Object>> treeList = JsonUtil.fromJson(string, new ArrayList<Map<String, Object>>(){}.getClass());
		for (Map<String, Object> map : treeList) {
			Object href = map.get("url");
			if (null == href) {
				continue;
			} else if (uri.contains(href.toString())) {
				flag = 1;
				break;
			}
		}
		
		if (1 == flag) {
			return true;
		} else {
			return false;
		}
	}
	
}
