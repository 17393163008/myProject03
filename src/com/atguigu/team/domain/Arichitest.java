package com.atguigu.team.domain;

public class Arichitest extends Designer {
	private int stock;

	public Arichitest(int id, String name, int age, double salary, int stock) {
		super(id, name, age, salary);
		this.stock = stock;
	}
	
	

	public Arichitest(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}



	public Arichitest(int id, String name, int age, double salary) {
		super(id, name, age, salary);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" +  getEquipment().getDescription();
	}
}
