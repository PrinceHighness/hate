/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.jk.service.user.impl 
 * 创建日期:2017年7月17日上午11:05:33 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.user.UserDao;
import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;
import com.jk.pojo.user.UserRequest;
import com.jk.pojo.user.UserResponse;
import com.jk.service.user.UserService;

import common.constant.Constant;
import common.util.JedisUtil;
import common.util.JsonUtil;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午11:05:33    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午11:05:33    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#insertUser(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public void insertUser(UserRequest userRequest) {
		System.out.println("service层：" + userRequest.getUserAccount());
		userDao.insertUser(userRequest);
		userRequest.setRoleID(1);
		userDao.insertUserRole(userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#selectUserList(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public List<UserResponse> selectUserList(UserRequest userRequest) {
		return userDao.selectUserList(userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#login(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public Map<String, Object> login(UserRequest userRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		//默认设置密码错误
		map.put("flag", Constant.LOGIN_PWD_ERROR);
		map.put("userInfo", null);
		
		//判断验证码
		if (null == userRequest.getUserImgCode() || "".equals(userRequest.getUserImgCode())) {
			//验证码为空
			map.put("flag", Constant.LOGIN_CODE_NULL);
		} else if (userRequest.getUserImgCode().equals(userRequest.getSysImgCode())) {
			
			
			
			 //连接数据库，查询用户信息
			UserResponse userResponse = userDao.login(userRequest);
			
			//判断是否被锁定（小于连续3次失败并且距离最近一次失败大于5分钟）
			if (null == userResponse) {
				//用户不存在
				map.put("flag", Constant.LOGIN_ACCOUNT_ERROR);
			} else if (0 == userResponse.getLoginFailNum()
					|| 0 < (userResponse.getLoginFailNum() % 3)
					|| userResponse.getLoginFailDate() > 300000) {
				if (userResponse.getUserPwd().equals(userRequest.getUserPwd())) {
					//登陆成功
					map.put("flag", Constant.LOGIN_SUCCESS);
					//用户信息放入map中
					map.put("userInfo", userResponse);
					userRequest.setLoginFailNum(0);
				} else {
					//密码错误
					//连接数据库，修改登陆失败的次数
					int loginFailNum = 1;
					if (userResponse.getLoginFailDate() > 300000) {
						userRequest.setLoginFailNum(1);
					} else {
						userRequest.setLoginFailNum(userResponse.getLoginFailNum() + 1);
						loginFailNum = userResponse.getLoginFailNum() + 1;
					}
					map.put("loginfailnum", loginFailNum);
				}
				//修改登陆失败次数
				userDao.updateLoginFailNum(userRequest);
			} else {
				//锁定
				map.put("flag", Constant.ACCOUNT_LOCKED);
			}
		} else {
			//验证码错误
			map.put("flag", Constant.LOGIN_CODE_ERROR);
		}
		return map;
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#selectUserRoleListJson(com.jk.pojo.role.RoleRequest)    
	 */
	@Override
	public List<RoleResponse> selectUserRoleListJson(RoleRequest roleRequest) {
		return userDao.selectUserRoleListJson(roleRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#insertUserRoleList(java.util.List)    
	 */
	@Override
	public void insertUserRoleList(List<RoleRequest> roleRequestList) {
		// 1、删除用户之前的所有角色（mid）
		userDao.deleteAllRolesByUserID(roleRequestList.get(0));
		// 2、添加用户勾选的所有角色（mid）
		userDao.insertUserRoleList(roleRequestList);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#selectUserCount(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public int selectUserCount(UserRequest userRequest) {
		return userDao.selectUserCount(userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#selectTreeListJson(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest) {
		List<Map<String, Object>> treeList = new ArrayList<Map<String,Object>>();
		//从redis缓存中获取权限列表
		String string = JedisUtil.getString(menuRequest.getUserID() + "#menu_list");
		//如果没有获取到，则查询数据库，
		if (null == string) {
			treeList = userDao.selectTreeListJson(menuRequest);
			if (null != treeList && 0 < treeList.size()) {
				//开始调用递归
				treeList = queryTreeListNodes(treeList, menuRequest);
			}
			//把查询的结果存一份到redis上
			JedisUtil.setString(menuRequest.getUserID() + "#menu_list", 
					JsonUtil.toJsonString(treeList), 600);
		} else {
			//如果查询到了结果，直接返回
			treeList = JsonUtil.fromJson(string, new ArrayList<Map<String, Object>>(){}.getClass());
		}
		return treeList;
	}
	
	//递归查询树菜单
	private List<Map<String, Object>> queryTreeListNodes(List<Map<String, Object>> treeList, MenuRequest menuRequest) {
		for (Map<String, Object> map : treeList) {
			if ("0".equals(map.get("pid").toString())) {
				//取出ID作为下次查询的pid
				int pid = Integer.valueOf(map.get("id").toString());
				menuRequest.setPid(pid);
				List<Map<String, Object>> queryTreeListNodes = 
						queryTreeListNodes(userDao.selectTreeListJson(menuRequest), menuRequest);
				map.put("nodes", queryTreeListNodes);
			}
		}
		return treeList;
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.user.UserService#selectUserMenuListJson(com.jk.pojo.menu.MenuRequest)    
	 */
	@Override
	public List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest) {
		return userDao.selectUserMenuListJson(menuRequest);
	}
}
