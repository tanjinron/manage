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
	
	@Override  //��ѯ���в���
	public List<Tpart> findTpaet() {
		
		List<Tpart> list = tpaetMapper.findTpaet();
		
		return list;
	}

	//��Ӳ�����Ϣ
	public void addTpaet(Tpart tpart){
		
		tpaetMapper.addTpaet(tpart);
	}

	@Override  //ɾ��������Ϣ  �޸Ĳ���״̬
	public void deleteTpaet(Integer pid) {
		
		//ɾ������ʱ���Ȳ�ѯ�ò���������Ա��
		List<Temp> list = tempMapper.TpaetANDTemp(pid);
		for (Temp temp : list) {
			tempMapper.Tpartdelete(temp.getTid());
		}
		
		tpaetMapper.deleteTpaet(pid);
		
	}

	@Override  //�޸Ĳ�����Ϣ
	public void updateTpaet(Tpart tpart) {
		
		tpaetMapper.updateTpaet(tpart);
	}

	@Override  //���ݱ�Ų�ѯ������Ϣ
	public Tpart IDpart(int pid) {
		
		return tpaetMapper.IDpart(pid);
	}
	
}
