package org.zhousy.manager.domain;

/*********************
 * 
 * @author zhousy
 *  ����Ա
 */
public class Tuser {
	
	private Integer gid;       //����Ա���
	private String grealname;  //����Ա��ʵ����
	private String gusername;  //��¼��
	private String gpassword;  //����
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGrealname() {
		return grealname;
	}
	public void setGrealname(String grealname) {
		this.grealname = grealname;
	}
	public String getGusername() {
		return gusername;
	}
	public void setGusername(String gusername) {
		this.gusername = gusername;
	}
	public String getGpassword() {
		return gpassword;
	}
	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}
	
}
