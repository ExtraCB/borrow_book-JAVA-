package model;

public class Book_Model {
	private String b_id;
	private String b_name;
	private String b_writer;
	private int b_category;
	private int b_price;
	
	
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public int getB_category() {
		return b_category;
	}
	public void setB_category(int b_category) {
		this.b_category = b_category;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	
	
	public Book_Model(String b_id, String b_name, String b_writer, int b_category, int b_price) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_writer = b_writer;
		this.b_category = b_category;
		this.b_price = b_price;
	}
	
	
	
}
