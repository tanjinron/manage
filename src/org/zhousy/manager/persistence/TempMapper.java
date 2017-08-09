package org.zhousy.manager.persistence;

import java.util.List;
import java.util.Map;

import org.zhousy.manager.domain.Temp;

public interface TempMapper {
	
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
	
	//删除部门时，员工的处理  将员工状态改为2
	void Tpartdelete(Integer tid);
	
	//查询所有员工信息并分页
	List<Temp> pageTemp(Map<String, Object> params);
	
	//查询总记录条数
	long countEMP();
	
	//根据编号查询员工详细信息 
	Temp getIDemp(Integer tid);

}
