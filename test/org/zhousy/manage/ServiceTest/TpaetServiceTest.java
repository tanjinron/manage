package org.zhousy.manage.ServiceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.service.TpaetService;

/********************
 * 
 * @author zhousy
 *  Ա�����������
 */
public class TpaetServiceTest {
	
	private TpaetService tpaetService;

	@Before
	public void init() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		tpaetService = ctx.getBean(TpaetService.class);
	}
	
	@Test     //��ѯ���в���
	public void findTpaetTest(){
		
		List<Tpart> list = tpaetService.findTpaet();
		
		for (Tpart tpart : list) {
			
			System.out.println(tpart.getPname());
		}
	}
	
	@Test  //��Ӳ�����Ϣ
	public void addTpaetTest(){
		
		Tpart tpart = new Tpart();
		tpart.setPname("����2��");
		tpart.setPremark("�з�����ӭ�㣡");
		
		tpaetService.addTpaet(tpart);
	}
	
	@Test   //ɾ��������Ϣ  �޸Ĳ���״̬
	public void deleteTpaet(){
		
		tpaetService.deleteTpaet(4);
	}
	
	@Test  //�޸Ĳ�����Ϣ
	public void updateTpaet(){
		
		Tpart tpart = new Tpart();
		tpart.setPid(2);
		tpart.setPname("����1��");
		tpart.setPremark("����1����ӭ�㣡");
		tpaetService.updateTpaet(tpart);
	}

}
