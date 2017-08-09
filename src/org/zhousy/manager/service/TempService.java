package org.zhousy.manager.service;

import java.util.List;
import java.util.Map;

import org.zhousy.manager.bean.PageBean;
import org.zhousy.manager.domain.Temp;

public interface TempService {

	//��ѯ����Ա����Ϣ
	List<Temp> findAllTEmp();
	
	//���Ա����Ϣ
	void addTemp(Temp temp);
	
	//ɾ��Ա����Ϣ   �޸�Ա��״̬
	void deleteTemp(Integer tid);
	
	//�޸�Ա����Ϣ
	void updateTemp(Temp temp);
	
	//��ѯ�����µ�����Ա��        ���ű��
	List<Temp> TpaetANDTemp(int pid);
	
	//��ѯ����Ա����Ϣ����ҳ
	PageBean<Temp> pageTemp(int pageNo);
	
	//���ݱ�Ų�ѯԱ����ϸ��Ϣ 
	Temp getIDemp(Integer tid);
	
	//��ѯ���в���   ��  ���ݱ�Ų�ѯԱ����Ϣ
	public Map<String, Object> empidANDpart(Integer tid);
		
}
