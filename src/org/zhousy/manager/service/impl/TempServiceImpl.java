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
	private TempMapper tempMapper;   //Ա��
	@Autowired
	private TpaetMapper tpaetMapper;   //����

	@Override  //��ѯ����Ա����Ϣ
	public List<Temp> findAllTEmp() {
		
		return tempMapper.findAllTEmp();
	}

	@Override   //���Ա����Ϣ
	public void addTemp(Temp temp) {
		
		tempMapper.addTemp(temp);
	}

	@Override   //ɾ��Ա����Ϣ   �޸�Ա��״̬
	public void deleteTemp(Integer tid) {
		
		tempMapper.deleteTemp(tid);
	}

	@Override   //�޸�Ա����Ϣ
	public void updateTemp(Temp temp) {
		
		tempMapper.updateTemp(temp);
	}

	@Override   //��ѯ�����µ�����Ա��        ���ű��
	public List<Temp> TpaetANDTemp(int pid) {
		
		return tempMapper.TpaetANDTemp(pid);
	}

	@Override    //��ѯ����Ա����Ϣ����ҳ
	public PageBean<Temp> pageTemp(int pageNo) {
		
		Map<String, Object> params = new HashMap<String,Object>();
		
		PageBean<Temp> page = new PageBean<Temp>(pageNo,5);
		params.put("page", page);
		//��ѯ�ܼ�¼����
		long totalItems = tempMapper.countEMP();
		// ���õ�pageBean������
		page.setTotalItems(totalItems);
		//��ѯ��Ӧ�ļ�¼
		List<Temp> list = tempMapper.pageTemp(params);
		page.setResult(list);
		
		return page;
	}

	@Override    //���ݱ�Ų�ѯԱ����ϸ��Ϣ 
	public Temp getIDemp(Integer tid) {
		
		return tempMapper.getIDemp(tid);
	}
	
	//��ѯ���в���   ��  ���ݱ�Ų�ѯԱ����Ϣ
	public Map<String, Object> empidANDpart(Integer tid){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Temp temp = tempMapper.getIDemp(tid);   //���ݱ�Ų�ѯԱ����ϸ��Ϣ 
		map.put("temp", temp);
		List<Tpart> listPart = tpaetMapper.findTpaet();
		map.put("listPart", listPart);     //  ��ѯ���в���  
		return map;
	}


	

}
