/** 
 * <pre>项目名称:ssi-controller-01 
 * 文件名称:MenuController.java 
 * 包名:com.jk.controller.menu 
 * 创建日期:2017年7月27日上午11:28:16 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.service.menu.MenuService;

/** 
 * <pre>项目名称：ssi-controller-01    
 * 类名称：MenuController    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月27日 上午11:28:16    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月27日 上午11:28:16    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/menu/")
public class MenuController {
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping("toMenuListPage")
	String toMenuListPage() {
		return "menu/menu_list";
	}
	
	@RequestMapping("selectMenuListJson")
	@ResponseBody
	List<MenuResponse> selectMenuListJson(MenuRequest menuRequest) {
		List<MenuResponse> menuList = menuService.selectMenuListJson(menuRequest);
		return menuList;
	}
	
	@RequestMapping("toAddMenuPage")
	String toAddMenuPage(Model m) {
		//查询一级菜单列表，展示到添加页面
		List<MenuResponse> menuList = menuService.selectFirstMenuList(new MenuRequest());
		m.addAttribute("menuList", menuList);
		return "menu/add_menu";
	}
	
	@RequestMapping("insertMenu")
	@ResponseBody
	String insertMenu(MenuRequest menuRequest) {
		menuService.insertMenu(menuRequest);
		return "{}";
	}

}
