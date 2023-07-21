package model;

public class Stats_Model {
	private String name;
	private String count;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
	public Stats_Model(String name, String count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	
	
	
}
