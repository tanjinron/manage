package org.zhousy.manager.persistence;

import java.util.List;
import java.util.Map;

import org.zhousy.manager.domain.Temp;

public interface TempMapper {
	
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
	
	//ɾ������ʱ��Ա���Ĵ���  ��Ա��״̬��Ϊ2
	void Tpartdelete(Integer tid);
	
	//��ѯ����Ա����Ϣ����ҳ
	List<Temp> pageTemp(Map<String, Object> params);
	
	//��ѯ�ܼ�¼����
	long countEMP();
	
	//���ݱ�Ų�ѯԱ����ϸ��Ϣ 
	Temp getIDemp(Integer tid);

}
