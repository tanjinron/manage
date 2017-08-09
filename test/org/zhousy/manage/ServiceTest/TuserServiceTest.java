package org.zhousy.manage.ServiceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhousy.manager.domain.Tuser;
import org.zhousy.manager.service.TuserService;

public class TuserServiceTest {
	
	private TuserService tuserService;

	@Before
	public void init() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		tuserService = ctx.getBean(TuserService.class);
	}
	
	
	@Test   //��¼
	public void loginTuserTest(){
		
		Tuser tuser = new Tuser();
		tuser.setGusername("admin");
		tuser.setGpassword("svse");
		Tuser tuser2 = tuserService.loginTuser(tuser);
		
		System.out.println(tuser2.getGrealname());
	}
	
	@Test  //��ӹ���Ա
	public void addTuserTest(){
		Tuser tuser = new Tuser();
		tuser.setGrealname("С��");
		tuser.setGusername("admin2");
		tuser.setGpassword("svse2");
		
		tuserService.addTuser(tuser);
	}
	
	@Test  //��ӹ���Ա
	public void updateTuser(){
		Tuser tuser = new Tuser();
		tuser.setGid(1);
		tuser.setGrealname("aa");
		
		tuserService.updateTuser(tuser);
	}
	
	@Test  //��ѯ����ǰ����Ա����Ĺ���Ա
	public void checkTuser(){
		
		List<Tuser> list = tuserService.checkTuser(1);
		for (Tuser tuser : list) {
			
			System.out.println(tuser.getGusername());
		}
		
	}
	
	
}
