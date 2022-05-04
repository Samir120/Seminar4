package se.kth.iv1350.saleprocess.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemDTOTest {
	private ItemDTO itemDTO;

	@BeforeEach
	public void setUp() {
		itemDTO = new ItemDTO("ZETA checkpeas", "0002", "The firm consistency of chickpeas", 15.00, 0.15, 1);
	}

	@AfterEach
	public void tearDown() {
		itemDTO = null;
	}

	@Test
	public void testGetName() {
		String expResult = "ZETA checkpeas";
		String result = itemDTO.getName();
		assertEquals(expResult, result, "Got wrong name from getName()");
	}
	
	@Test
	public void testGetItemIdentifier() {
		String expResult = "0002";
		String result = itemDTO.getItemIdentifier();
		assertEquals(expResult, result, "Got wrong identifier from getItemIdentifier()");
	}
	
	@Test
	public void testGetDescription() {
		String expResult = "The firm consistency of chickpeas";
		String result = itemDTO.getDescription();
		assertEquals(expResult, result, "Got wrong description from getDescription()");
	}
	
	@Test
	public void testGetPrice() {
		double expResult = 0.15;
		double result = itemDTO.getVAT();
		assertEquals(expResult, result, "Got wrong price from getPrice()");
	}
	
	@Test
	public void testGetVAT() {
		double expResult = 15.00;
		double result = itemDTO.getPrice();
		assertEquals(expResult, result, "Got wrong VAT from getVAT()");
	}
	
	@Test
	public void testGetSoldQuantity() {
		int expResult = 1;
		int result = itemDTO.getSoldQuantity();
		assertEquals(expResult, result, "Got wrong quantity from getSoldQuantity()");
	}
	
	@Test
	public void testIncreaseSoldQuantity() {
		int expResult = 2;
		itemDTO.increaseSoldQuantity();
		int result = itemDTO.getSoldQuantity();
		assertEquals(expResult, result, "Got wrong quantity from increaseSoldQuantity()");
	}

}
