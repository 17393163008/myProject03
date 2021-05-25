package com.atguigu.team.service;

import com.atguigu.team.domain.Arichitest;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

public class NameListService {
	private Employee[] employees;
	
	/**
	 * 给employee及数组元素进行初始化
	 */
	
	public NameListService() {
		//1、根据项目提供的Data类构建相应大小的employee数组
		//2、再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer、Architest
		//3、将对象存于数组中
		employees = new Employee[Data.EMPLOYEES.length];
		
		for (int i = 0; i < employees.length; i++) {
			//获取员工类型
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			
			//获取Employee的四个基本信息
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			
			switch (type) {
			case Data.EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case Data.PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case Data.DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment,bonus);
				break;
			case Data.ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Arichitest(id, name, age, salary, equipment, bonus, stock);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * 获取指定index上员工的设备
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int i) {
		int type = Integer.parseInt(Data.EQUIPMENTS[i][0]);
		String model = Data.EQUIPMENTS[i][1];
		switch (type) {
		case Data.PC:
			String display = Data.EQUIPMENTS[i][0];
			return new PC(model,display);
		case Data.NOTEBOOK:
			double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
			return new NoteBook(model,price);
		case Data.PRINTER:
			
			return new Printer(model,Data.EMPLOYEES[i][2]);

		default:
			break;
		}
		return null;
		
		
	}
	
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if(employees[i].getId()==id) {
				return employees[i];
			}
		}
		
		throw new TeamException("找不到指定的员工");
	}

}
