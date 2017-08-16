/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserController.java 
 * 包名:com.jk.controller.user 
 * 创建日期:2017年7月17日上午10:44:54 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;
import com.jk.pojo.user.UserRequest;
import com.jk.pojo.user.UserResponse;
import com.jk.service.user.UserService;

import common.base.MySessionContext;
import common.util.DateUtil;
import common.util.FTPUtil;
import common.util.FileUtil;
import common.util.JedisUtil;
import common.util.JsonUtil;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午10:44:54    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午10:44:54    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;

//	@RequestMapping("insertUser")
//	String insertUser(UserRequest userRequest) {
//		System.out.println(userRequest.getUserAccount()
//				+ "一支穿云箭"
//				+ userRequest.getUserPwd());
//		userService.insertUser(userRequest);
//		//重定向
//		return "redirect:selectUserList.jhtml";
//	}
	
	@RequestMapping("insertUser")
	@ResponseBody
	String insertUser(UserRequest userRequest) {
		System.out.println(userRequest.getUserAccount()
				+ "一支穿云箭"
				+ userRequest.getUserPwd());
		userService.insertUser(userRequest);
		//重定向
		return "{}";
	}
	
	@RequestMapping("selectUserList")
	ModelAndView selectUserList(UserRequest userRequest) {
		System.out.println("hello world");
		ModelAndView mv = new ModelAndView();
		List<UserResponse> userList = userService.selectUserList(userRequest);
		mv.addObject("ul", userList);
		mv.setViewName("user/success");
		return mv;
	}
	
//	@RequestMapping("selectUserListJson")
//	void selectUserListJson(UserRequest userRequest, HttpServletResponse response) {
//		System.out.println("hello world");
//		List<UserResponse> userList = userService.selectUserList(userRequest);
//		//String json = new Gson().toJson(userList);
//		String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
//				.toJson(userList);
//		System.out.println(json);
//		response.setCharacterEncoding("utf-8");
//		try {
//			PrintWriter writer = response.getWriter();
//			writer.write(json);
//			writer.flush();
//			writer.close();
//			writer = null;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@RequestMapping("selectUserListJson")
	@ResponseBody
	Map<String, Object> selectUserListJson(String pageNumber, UserRequest userRequest) {
		System.out.println("hello world");
		
		//查询总条数
		int totalCount = userService.selectUserCount(userRequest);
		userRequest.setTotalCount(totalCount);
		if (null == pageNumber || "".equals(pageNumber.trim())) {
			pageNumber = "1";
		}
		userRequest.setPageIndex(Integer.valueOf(pageNumber));
		//计算分页信息
		userRequest.calculate();
		//查询列表
		List<UserResponse> userList = userService.selectUserList(userRequest);
		//封装结果
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalCount);
		map.put("rows", userList);
		return map;
	}
	
	@RequestMapping("login")
	@ResponseBody
	Map<String, Object> login(UserRequest userRequest, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object codeObj = session.getAttribute("imageCode");
		if (null == codeObj) {
			codeObj = "";
		}
		String code = codeObj.toString();
		userRequest.setSysImgCode(code);
		Map<String, Object> map = userService.login(userRequest);
		Object userInfo = map.get("userInfo");
		if (null != userInfo) {
			UserResponse userResponse = (UserResponse) userInfo;
			//用户信息放进session中
			session.setAttribute("userInfo", userInfo);
			//设置session过期时间(单位：秒)
			session.setMaxInactiveInterval(1200);
			
			String userID = userResponse.getUserID() + "";
			MySessionContext.removeSession(userID, session);
			MySessionContext.addSession(userID, session);
			
			//查询出用户的权限树
			MenuRequest menuRequest = new MenuRequest();
			int userID2 = userResponse.getUserID();
			System.out.println(userID2);
			menuRequest.setUserID(userResponse.getUserID());
			
			List<MenuResponse> treeList = userService.selectUserMenuListJson(menuRequest);
			//放到redis中
			JedisUtil.setString(userID + "#tree_list", JsonUtil.toJsonString(treeList), 1);
		}
		return map;
	}
	
	@RequestMapping("logout")
	String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:../login.jsp";
	}
	
	@RequestMapping("toUserListPage")
	String toUserListPage() {
		
		return "user/user_list";
	}
	
	@RequestMapping("toUserRolePage")
	String toUserRolePage(ModelMap mm, UserRequest userRequest) {
		mm.addAttribute("userID", userRequest.getUserID());
		return "user/user_role";
	}
	
	@RequestMapping("selectUserRoleListJson")
	@ResponseBody
	List<RoleResponse> selectUserRoleListJson(RoleRequest roleRequest) {
		List<RoleResponse> roleList = userService.selectUserRoleListJson(roleRequest);
		return roleList;
	}
	
	@RequestMapping("insertUserRoleList")
	@ResponseBody
	String insertUserRoleList(@RequestBody List<RoleRequest> roleRequestList) {
		userService.insertUserRoleList(roleRequestList);
		return "{}";
	}
	
	@RequestMapping("toAddUserPage")
	String toAddUserPage() {
		return "user/add_user";
	}
	
	@RequestMapping("selectTreeListJson")
	@ResponseBody
	List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest) {
		List<Map<String, Object>> treeList = userService.selectTreeListJson(menuRequest);
		return treeList;
	}
	
	@RequestMapping("uploadUserPhoto")
	void uploadUserPhoto(MultipartFile userPhoto) {
		try {
			InputStream inputStream = userPhoto.getInputStream();
			String md5 = FileUtil.getMD5(inputStream, "md5");
			//从数据库判断这个指纹存在
			System.out.println("文件指纹是：" + md5);
			//如果存在，直接把地址返回给用户
			
			//如果不存在，保存这个文件到FTP服务器，并且把保存的路径以及文件指纹存到数据库
			//文件名
			String originalFilename = userPhoto.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + suffix;
			String path = "1702A/" + DateUtil.formatDateToString(new Date(), "yyyy/MM/dd");
			boolean boo = FTPUtil.uploadFile(userPhoto.getInputStream(), fileName, path);
			if (boo) {
				System.out.println("文件上传成功，保存在：》》" + path + "/" + fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
	
}
