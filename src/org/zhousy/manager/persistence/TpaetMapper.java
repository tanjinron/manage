package org.zhousy.manager.persistence;

import java.util.List;

import org.zhousy.manager.domain.Tpart;

/****************
 * 
 * @author zhousy
 *  部门管理   增删查改
 */
public interface TpaetMapper {

	//查询所有部门
	List<Tpart> findTpaet();
	
	//添加部门信息
	void addTpaet(Tpart tpart);
	
	//删除部门信息  修改部门状态
	void deleteTpaet(Integer pid);
	
	//修改部门信息
	void updateTpaet(Tpart tpart);
	
	//根据编号查询部门信息
	Tpart IDpart(int pid);
	
}
