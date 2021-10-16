package com.TV.system.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TvSystemTestApplicationTests {

	@Test
	void contextLoads() {
	}
	
	class Calculator{
		int add(int a, int b) {return a + b;}
	}
	
	Calculator underTest = new Calculator();
	
	@Test
	void addTowSum() {
		//given
		int num1 = 10;
		int num2 = 20;
		
		//when
		int result = underTest.add(num1, num2);
		
		//then
		assertEquals(30, result);
	}
	
}
