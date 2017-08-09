package org.zhousy.manager.domain;

/*********************
 * 
 * @author zhousy
 *  管理员
 */
public class Tuser {
	
	private Integer gid;       //管理员编号
	private String grealname;  //管理员真实姓名
	private String gusername;  //登录名
	private String gpassword;  //密码
	
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
