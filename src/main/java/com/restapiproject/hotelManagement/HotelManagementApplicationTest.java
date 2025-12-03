package com.restapiproject.hotelManagement;

import org.junit.jupiter.api.Test;

class Calculator{
	public int add(int a, int b) {
		return a + b;
	}
}

class CalculatorTest{
	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		int result =  calc.add(12, 13);
//		assetEquals(25, result, "12+13 should be 25");
	}
}

public class HotelManagementApplicationTest {

}
