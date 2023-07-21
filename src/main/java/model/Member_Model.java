package model;

public class Member_Model {
	private String  m_user;
	private String m_pass;
	private String m_name;
	private String m_phone;
	
	
	public String getM_user() {
		return m_user;
	}
	public void setM_user(String m_user) {
		this.m_user = m_user;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	
	
	public Member_Model(String m_user, String m_pass, String m_name, String m_phone) {
		super();
		this.m_user = m_user;
		this.m_pass = m_pass;
		this.m_name = m_name;
		this.m_phone = m_phone;
	}
	
	
	
	
	
	
}
