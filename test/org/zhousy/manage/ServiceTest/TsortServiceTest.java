package org.zhousy.manage.ServiceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhousy.manager.domain.Tsort;
import org.zhousy.manager.service.TsortService;

/******************************
 * 
 * @author zhousy
 *   ��Ʒ����������
 */
public class TsortServiceTest {
	
	private TsortService tsortService;
	
	@Before
	public void init() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		tsortService = ctx.getBean(TsortService.class);
	}
	
	@Test     //��Ӳ�Ʒ���
	public void addTest(){
		
		Tsort tsort = new Tsort();
		tsort.setBname("��Ϊ");
		tsort.setBremark("�ֻ�");
		
		tsortService.addTsort(tsort);
		
	}
	
	@Test     //ɾ�������Ϣ   �޸�״̬
	public void deleteTest(){
		
		tsortService.deleteTsort(1);
	}
	
	@Test    //��ѯ���в�����Ϣ
	public void listTest(){
		
		List<Tsort> list = tsortService.findTsort();
		for (Tsort tsort : list) {
			
			System.out.println(tsort.getBname());
		}
	}
	
	@Test    //�޸Ĳ�����Ϣ
	public void updateTest(){
		
		Tsort tsort = new Tsort();
		tsort.setBid(1);
		tsort.setBname("oppo");
		tsort.setBremark("�úú�");
		
		tsortService.updateTsort(tsort);
	}
	

}
