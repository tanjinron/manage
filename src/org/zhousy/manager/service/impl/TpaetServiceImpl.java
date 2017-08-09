package org.zhousy.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhousy.manager.domain.Temp;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.persistence.TempMapper;
import org.zhousy.manager.persistence.TpaetMapper;
import org.zhousy.manager.service.TpaetService;

@Service
public class TpaetServiceImpl implements TpaetService {

	@Autowired
	private TpaetMapper tpaetMapper;
	@Autowired
	private TempMapper tempMapper;
	
	@Override  //查询所有部门
	public List<Tpart> findTpaet() {
		
		List<Tpart> list = tpaetMapper.findTpaet();
		
		return list;
	}

	//添加部门信息
	public void addTpaet(Tpart tpart){
		
		tpaetMapper.addTpaet(tpart);
	}

	@Override  //删除部门信息  修改部门状态
	public void deleteTpaet(Integer pid) {
		
		//删除部门时，先查询该部门下所有员工
		List<Temp> list = tempMapper.TpaetANDTemp(pid);
		for (Temp temp : list) {
			tempMapper.Tpartdelete(temp.getTid());
		}
		
		tpaetMapper.deleteTpaet(pid);
		
	}

	@Override  //修改部门信息
	public void updateTpaet(Tpart tpart) {
		
		tpaetMapper.updateTpaet(tpart);
	}

	@Override  //根据编号查询部门信息
	public Tpart IDpart(int pid) {
		
		return tpaetMapper.IDpart(pid);
	}
	
}
