package org.zhousy.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhousy.manager.bean.PageBean;
import org.zhousy.manager.domain.Temp;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.persistence.TempMapper;
import org.zhousy.manager.persistence.TpaetMapper;
import org.zhousy.manager.service.TempService;

@Service
public class TempServiceImpl implements TempService{
	
	@Autowired
	private TempMapper tempMapper;   //员工
	@Autowired
	private TpaetMapper tpaetMapper;   //部门

	@Override  //查询所有员工信息
	public List<Temp> findAllTEmp() {
		
		return tempMapper.findAllTEmp();
	}

	@Override   //添加员工信息
	public void addTemp(Temp temp) {
		
		tempMapper.addTemp(temp);
	}

	@Override   //删除员工信息   修改员工状态
	public void deleteTemp(Integer tid) {
		
		tempMapper.deleteTemp(tid);
	}

	@Override   //修改员工信息
	public void updateTemp(Temp temp) {
		
		tempMapper.updateTemp(temp);
	}

	@Override   //查询部门下的所有员工        部门编号
	public List<Temp> TpaetANDTemp(int pid) {
		
		return tempMapper.TpaetANDTemp(pid);
	}

	@Override    //查询所有员工信息并分页
	public PageBean<Temp> pageTemp(int pageNo) {
		
		Map<String, Object> params = new HashMap<String,Object>();
		
		PageBean<Temp> page = new PageBean<Temp>(pageNo,5);
		params.put("page", page);
		//查询总记录条数
		long totalItems = tempMapper.countEMP();
		// 设置到pageBean对象中
		page.setTotalItems(totalItems);
		//查询对应的记录
		List<Temp> list = tempMapper.pageTemp(params);
		page.setResult(list);
		
		return page;
	}

	@Override    //根据编号查询员工详细信息 
	public Temp getIDemp(Integer tid) {
		
		return tempMapper.getIDemp(tid);
	}
	
	//查询所有部门   和  根据编号查询员工信息
	public Map<String, Object> empidANDpart(Integer tid){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Temp temp = tempMapper.getIDemp(tid);   //根据编号查询员工详细信息 
		map.put("temp", temp);
		List<Tpart> listPart = tpaetMapper.findTpaet();
		map.put("listPart", listPart);     //  查询所有部门  
		return map;
	}


	

}
