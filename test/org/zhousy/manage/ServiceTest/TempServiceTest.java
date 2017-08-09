package org.zhousy.manage.ServiceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.zhousy.manager.bean.PageBean;
import org.zhousy.manager.domain.Temp;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.service.TempService;

public class TempServiceTest {
	
	private TempService tempService;
	
	@Before
	public void init() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		tempService = ctx.getBean(TempService.class);

	}
	
	@Test  // ��ѯ����Ա����Ϣ
	public void findAllTest(){
		
		List<Temp> list = tempService.findAllTEmp();
		for (Temp temp : list) {
			System.out.println(temp.getTid());
			System.out.println(temp.getTrealname());
			System.out.println(temp.getTpid().getPname());
		}
	}
	
	@Test  //���Ա����Ϣ
	public void addTest(){
		
		Tpart tpart = new Tpart();
		tpart.setPid(4);
		Temp temp = new Temp();
		temp.setTrealname("С��");
		temp.setTaddress("����ʡ");
		temp.setTage(22);
		temp.setTpid(tpart);
		temp.setTsex(1);
		temp.setTtel("12345678910");
		
		tempService.addTemp(temp);
	}
	
	@Test   //ɾ��Ա����Ϣ   �޸�Ա��״̬
	public void deleteTest(){
		
		tempService.deleteTemp(1);
	}
	
	@Test     //�޸�Ա����Ϣ
	public void updateTemp(){
		Tpart tpart = new Tpart();
		tpart.setPid(2);
		Temp temp = new Temp();
		temp.setTid(1);
		temp.setTrealname("xx");
		temp.setTaddress("xx");
		temp.setTage(22);
		temp.setTpid(tpart);
		temp.setTsex(1);
		temp.setTtel("12345678910");
		
		tempService.updateTemp(temp);
	}
	
	@Test   //���ݲ��ű�Ų�ѯԱ����Ϣ
	public void TpaetANDTempTest(){
		
		
		List<Temp> list = tempService.TpaetANDTemp(2);
		
		for (Temp temp : list) {
			
			System.out.println(temp.getTrealname());
		}
		
	}
	
	@Test    //��ҳ����
	public void pageTest(){
		
		PageBean<Temp> pageBean = tempService.pageTemp(2);
		
		for (Temp temp : pageBean.getResult()) {
			
			System.out.println(temp.getTrealname());
		}
		
		System.out.println(pageBean.getDbIndex()+"----1");
		System.out.println(pageBean.getDbNumber()+"----2");
		System.out.println(pageBean.getPageNo()+"----3");
		System.out.println(pageBean.getTotalItems()+"---4");
		System.out.println(pageBean.getTotalPageNum()+"----5");
	}
	

}
