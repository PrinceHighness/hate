/** 
 * <pre>项目名称:ssi-dao-01 
 * 文件名称:MenuDaoImpl.java 
 * 包名:com.jk.dao.menu.impl 
 * 创建日期:2017年7月27日上午11:35:54 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.menu.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jk.dao.menu.MenuDao;
import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;

/** 
 * <pre>项目名称：ssi-dao-01    
 * 类名称：MenuDaoImpl    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月27日 上午11:35:54    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月27日 上午11:35:54    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class MenuDaoImpl extends SqlMapClientDaoSupport implements MenuDao {

	/* (non-Javadoc)    
	 * @see com.jk.dao.menu.MenuDao#selectMenuListJson(com.jk.pojo.menu.MenuRequest)    
	 */
	@Override
	public List<MenuResponse> selectMenuListJson(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("menu.selectMenuListJson", menuRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.menu.MenuDao#selectFirstMenuList(com.jk.pojo.menu.MenuRequest)    
	 */
	@Override
	public List<MenuResponse> selectFirstMenuList(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("menu.selectFirstMenuList", menuRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.menu.MenuDao#insertMenu(com.jk.pojo.menu.MenuRequest)    
	 */
	@Override
	public void insertMenu(MenuRequest menuRequest) {
		this.getSqlMapClientTemplate().insert("menu.insertMenu", menuRequest);
	}
}
