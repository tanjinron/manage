package org.zhousy.manager.domain;

/****************
 * 
 * @author zhousy
 *  ���ű�
 */
public class Tpart {
	
	private Integer pid;   //���ű��
	private String pname;  //�������� 
	private String premark;  //���Ž���
	private Integer pstatus;  //״̬   0Ϊ����  1Ϊɾ��
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPremark() {
		return premark;
	}
	public void setPremark(String premark) {
		this.premark = premark;
	}
	public Integer getPstatus() {
		return pstatus;
	}
	public void setPstatus(Integer pstatus) {
		this.pstatus = pstatus;
	}
	
}
