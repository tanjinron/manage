package org.zhousy.manager.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhousy.manager.domain.Tuser;
import org.zhousy.manager.service.TuserService;

@Controller
@RequestMapping("/tuser")
public class TuserController {
	
	@Autowired    //��ת����½ҳ��
	private TuserService tuserService;
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		
		return "login";
	}
	
	@RequestMapping("/login")    //����Ա��½
	public String login(Tuser tuser,HttpServletRequest request){
		
		Tuser tuser2 = tuserService.loginTuser(tuser);
		if(tuser2!=null){
			
			request.getSession().setAttribute("tuser", tuser2);
			return "main";  //${sessionScope.tuser.gid}
		}else{
			if(request.getSession().getAttribute("tuser")!=null){
				return "main";  
			}
			return "success";    //��ת����½ʧ��ҳ��
		}
	
	}
	
	@RequestMapping("/OutLogin")   //ע������Ա
	public String OutLogin(HttpServletRequest request){
		
		request.getSession().removeAttribute("tuser");
		return "login";
	}
	
	@RequestMapping("/addTuserUI")         //��ת����ӹ���Աҳ��
	public String addTuserUI(){
		
		return "/user/addTuser";
	}
	
	@RequestMapping("/addTuser")         //��ӹ���Ա
	public String addTuser(Tuser tuser){
		
		tuserService.addTuser(tuser);
		
		return "success";
	}
	
	@RequestMapping("/listTuserUI")  //��ת���鿴���й���Ա�˺���Ϣ
	public String listTuserUI(){
		
		return "/user/listTuser";
	}
	
	@ResponseBody
	@RequestMapping("/listTuser")       //��ѯ���й���Ա�˻���Ϣ
	public List<Tuser> listTuser(HttpServletRequest request){
		
		Tuser tuser = (Tuser) request.getSession().getAttribute("tuser");
		List<Tuser> list = tuserService.checkTuser(tuser.getGid());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getidTuser")    //���ݱ�Ų�ѯ����Ա��Ϣ
	public Tuser getidTuser(Integer gid){
		
		Tuser tuser = tuserService.getidTuser(gid);
		
		return tuser;
	}
	
	//�޸Ĺ���Ա��Ϣ
	@RequestMapping("/eduit")
	@ResponseBody
	public boolean eduit(Integer gid,String gusername,String grealname){
		try {
			Tuser tuser = new Tuser();
			tuser.setGid(gid);  tuser.setGrealname(grealname);  tuser.setGusername(gusername);
			tuserService.updateTuser(tuser);
			return true;
			
		} catch (Exception e) {

			return false;
		}
		
	}
	
	
	

}
