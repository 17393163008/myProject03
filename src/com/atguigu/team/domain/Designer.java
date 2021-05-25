package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Designer extends Programmer{	
	public Designer(int id, String name, int age, double salary) {
		super(id, name, age, salary);
	}
	
	

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}



	public Designer(int id, String name, int age, double salary, double bonus) {
		super(id, name, age, salary);
		this.bonus = bonus;
	}

	private double bonus;  //奖金

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
}
