/** 
 * <pre>项目名称:ssi-controller-01 
 * 文件名称:RoleController.java 
 * 包名:com.jk.controller.role 
 * 创建日期:2017年7月26日下午2:37:21 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;
import com.jk.service.role.RoleService;

/** 
 * <pre>项目名称：ssi-controller-01    
 * 类名称：RoleController    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月26日 下午2:37:21    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月26日 下午2:37:21    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/role/")
public class RoleController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping("toRoleListPage")
	String toRoleListPage() {
		return "role/role_list";
	}
	
	@RequestMapping("selectRoleListJson")
	@ResponseBody
	Map<String, Object> selectRoleListJson(String pageNumber, RoleRequest roleRequest) {
		//查询总条数
		int totalCount = roleService.selectRoleCount(roleRequest);
		roleRequest.setTotalCount(totalCount);
		if (null == pageNumber || "".equals(pageNumber.trim())) {
			pageNumber = "1";
		}
		roleRequest.setPageIndex(Integer.valueOf(pageNumber));
		//计算分页信息
		roleRequest.calculate();
		//查询列表
		List<RoleResponse> roleList = roleService.selectRoleList(roleRequest);
		//封装结果
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalCount);
		map.put("rows", roleList);
		return map;
	}
	
	@RequestMapping("toRoleMenuPage")
	String toRoleMenuPage(Model m, RoleRequest roleRequest) {
		m.addAttribute("roleID", roleRequest.getRoleID());
		return "role/role_menu";
	}
	
	@RequestMapping("selectRoleMenuListJson")
	@ResponseBody
	List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest) {
		List<MenuResponse> menuList = roleService.selectRoleMenuListJson(menuRequest);
		return menuList;
	}
	
	@RequestMapping("insertRoleMenuList")
	@ResponseBody
	String insertRoleMenuList(@RequestBody List<MenuRequest> menuRequestList) {
		roleService.insertRoleMenuList(menuRequestList);
		return "{}";
	}
}
