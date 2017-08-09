package org.zhousy.manager.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.service.TpaetService;

@Controller
@RequestMapping("/part")
public class TpartController {

	@Autowired
	private TpaetService tpaetService;
	
	@RequestMapping("/partUI")      //��ת����ʵ���в���ҳ��
	public String partUI(){
		
		return "/emp/tpart";
	}
	
	@ResponseBody
	@RequestMapping("/partlist")      //��ѯ���в�����Ϣ
	public List<Tpart> listpart(){
		
		List<Tpart> list = tpaetService.findTpaet();
		
		return list;
	}
	
	@RequestMapping("/addTpaetUI")   //��ת����Ӳ�����Ϣҳ��
	public String addTpaetUI(){
		
		return "/emp/addTpart";
	}
	
	@RequestMapping("/addTpart")    //��Ӳ�����Ϣ
	public String addTpart(Tpart tpart){
		
		tpaetService.addTpaet(tpart);
	
		return "/emp/tpart";
	}
	
	@ResponseBody
	@RequestMapping("/deleteTpart")  //ɾ��������Ϣ
	public Boolean deleteTpart(int pid){
		try {
			tpaetService.deleteTpaet(pid);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/idpart") //���ݱ�Ų�ѯ������Ϣ
	public Tpart idpart(int pid){
		
		Tpart tpart = tpaetService.IDpart(pid);
		
		return tpart;
	}
	
	@ResponseBody
	@RequestMapping("/uppart")    //�޸Ĳ�����Ϣ
	public Boolean uppart(Tpart tpart){
		try {
			tpaetService.updateTpaet(tpart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
