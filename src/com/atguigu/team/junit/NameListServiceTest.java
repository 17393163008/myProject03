package com.atguigu.team.junit;

import java.util.Scanner;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

/**
 * 对NameListService的一个测试
 * @author pan
 *
 */
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入id：");
		int id = scanner.nextInt();
		
		
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
