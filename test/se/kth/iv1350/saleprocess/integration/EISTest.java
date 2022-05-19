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
	public void testGetItem() throws InvalidItemIdentifierException, 
									DatabaseFailureException{
		ItemDTO item = new ItemDTO("BOB jam", "0005", "Raspberry jam with more berries", 35.00, 0.25, 1);
		ItemDTO result = null;
		String itemIdentifier = "0005";
		result = eis.getItem(itemIdentifier);
		assertTrue(result.getDescription().contains("Raspberry jam with more berries"), "Got wrong result from getItem()");
	}
	
	@Test
	public void testInvalidItemIdentifierException() throws InvalidItemIdentifierException, 
															DatabaseFailureException{
		String itemIdentifier = "0008";
		ItemDTO result = null;
		try {
			result = eis.getItem(itemIdentifier);
			fail("The exception is not executed.");
		}
		catch(InvalidItemIdentifierException e) {
			assertTrue(e.getMessage().contains("The item identifier: "), "InvalidItemIdentifierException is not executed.");
		}
	}
	
	@Test
	public void testDatabaseFailureException() throws InvalidItemIdentifierException, 
															DatabaseFailureException{
		ItemDTO result = null;
		String itemIdentifier = "0000";
		try {
			result = eis.getItem(itemIdentifier);
			fail("The exception is not executed.");
		}
		catch(DatabaseFailureException e) {
			assertTrue(e.getMessage().contains("Unable to connect to the database."), "DatabaseFailureException is not executed.");
		}
	}
	
}
