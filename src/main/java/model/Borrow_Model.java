package model;

public class Borrow_Model {
	private String br_date_br;
	private String br_date_rt;
	
	private Member_Model usr;
	private Book_Model book;
	
	private int br_fine;
	
	
	public int getBr_fine() {
		return br_fine;
	}
	public void setBr_fine(int br_fine) {
		this.br_fine = br_fine;
	}
	public String getBr_date_br() {
		return br_date_br;
	}
	public void setBr_date_br(String br_date_br) {
		this.br_date_br = br_date_br;
	}
	public String getBr_date_rt() {
		return br_date_rt;
	}
	public void setBr_date_rt(String br_date_rt) {
		this.br_date_rt = br_date_rt;
	}
	public Member_Model getUsr() {
		return usr;
	}
	public void setUsr(Member_Model usr) {
		this.usr = usr;
	}
	public Book_Model getBook() {
		return book;
	}
	public void setBook(Book_Model book) {
		this.book = book;
	}
	
	public Borrow_Model(String br_date_br, String br_date_rt, Member_Model usr, Book_Model book,int br_fine) {
		super();
		this.br_date_br = br_date_br;
		this.br_date_rt = br_date_rt;
		this.usr = usr;
		this.book = book;
		this.br_fine = br_fine;
	}
	
	
	
}
