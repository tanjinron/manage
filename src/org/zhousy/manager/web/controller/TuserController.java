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
	
	@Autowired    //跳转到登陆页面
	private TuserService tuserService;
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		
		return "login";
	}
	
	@RequestMapping("/login")    //管理员登陆
	public String login(Tuser tuser,HttpServletRequest request){
		
		Tuser tuser2 = tuserService.loginTuser(tuser);
		if(tuser2!=null){
			
			request.getSession().setAttribute("tuser", tuser2);
			return "main";  //${sessionScope.tuser.gid}
		}else{
			if(request.getSession().getAttribute("tuser")!=null){
				return "main";  
			}
			return "success";    //跳转到登陆失败页面
		}
	
	}
	
	@RequestMapping("/OutLogin")   //注销管理员
	public String OutLogin(HttpServletRequest request){
		
		request.getSession().removeAttribute("tuser");
		return "login";
	}
	
	@RequestMapping("/addTuserUI")         //跳转到添加管理员页面
	public String addTuserUI(){
		
		return "/user/addTuser";
	}
	
	@RequestMapping("/addTuser")         //添加管理员
	public String addTuser(Tuser tuser){
		
		tuserService.addTuser(tuser);
		
		return "success";
	}
	
	@RequestMapping("/listTuserUI")  //跳转到查看所有管理员账号信息
	public String listTuserUI(){
		
		return "/user/listTuser";
	}
	
	@ResponseBody
	@RequestMapping("/listTuser")       //查询所有管理员账户信息
	public List<Tuser> listTuser(HttpServletRequest request){
		
		Tuser tuser = (Tuser) request.getSession().getAttribute("tuser");
		List<Tuser> list = tuserService.checkTuser(tuser.getGid());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getidTuser")    //根据编号查询管理员信息
	public Tuser getidTuser(Integer gid){
		
		Tuser tuser = tuserService.getidTuser(gid);
		
		return tuser;
	}
	
	//修改管理员信息
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
