package se.kth.iv1350.saleprocess.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.saleprocess.DTO.ItemDTO;
import se.kth.iv1350.saleprocess.model.Sale;

class EISTest {
	private EIS eis;
	 private List<ItemDTO> listOfItems = new ArrayList<>();
	

	@BeforeEach
	public void setUp() {
		eis = new EIS();
	}

	@AfterEach
	public void tearDown() {
		eis = null;
	}
	
	@Test
	public void testGetItem() {
		ItemDTO item = new ItemDTO("BOB jam", "0005", "Raspberry jam with more berries", 35.00, 0.25, 1);
		ItemDTO result = null;
		String itemIdentifier = "0005";
		result = eis.getItem(itemIdentifier);
		assertTrue(result.getDescription().contains("Raspberry jam with more berries"), "Got wrong result from getItem()");
	}

	@Test
	public void testItemValidityWithExistingItem() {
		Boolean expResult = true;
		Boolean result;
		String itemIdentifier = "0002";
		result = eis.itemValidity(itemIdentifier);
		assertEquals(expResult, result, "Got wrong result form itemValidity()");
	}
	
	@Test
	public void testItemValidityWithNonExistentItem() {
		Boolean expResult = false;
		Boolean result;
		String itemIdentifier = "0007";
		result = eis.itemValidity(itemIdentifier);
		assertEquals(expResult, result, "Got wrong result form itemValidity()");
	}
	
}
