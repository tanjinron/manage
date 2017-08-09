package org.zhousy.manager.service;

import java.util.List;
import java.util.Map;

import org.zhousy.manager.bean.PageBean;
import org.zhousy.manager.domain.Temp;

public interface TempService {

	//查询所有员工信息
	List<Temp> findAllTEmp();
	
	//添加员工信息
	void addTemp(Temp temp);
	
	//删除员工信息   修改员工状态
	void deleteTemp(Integer tid);
	
	//修改员工信息
	void updateTemp(Temp temp);
	
	//查询部门下的所有员工        部门编号
	List<Temp> TpaetANDTemp(int pid);
	
	//查询所有员工信息并分页
	PageBean<Temp> pageTemp(int pageNo);
	
	//根据编号查询员工详细信息 
	Temp getIDemp(Integer tid);
	
	//查询所有部门   和  根据编号查询员工信息
	public Map<String, Object> empidANDpart(Integer tid);
		
}
