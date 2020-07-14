package com.haoge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculateTest {

	@Test
	void testAdd() {
		assertEquals(6,new Calculate().add(3, 3));
	}

	@Test
	void testSubstract() {
		assertEquals(2,new Calculate().substract(5, 3));
	}

	@Test
	void testCheng() {
		assertEquals(15,new Calculate().cheng(5, 3));
	}

	@Test
	void testChu() {
		assertEquals(2,new Calculate().chu(6, 3));
	}

}
