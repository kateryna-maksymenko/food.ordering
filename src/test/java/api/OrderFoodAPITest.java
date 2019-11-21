package api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.CuisineType;

public class OrderFoodAPITest {

	protected OrderFoodAPI api = new OrderFoodAPIImpl();

	@Test
	public void getLunchesBasedOnCuisineTest() {
		assertTrue(api.getLunchesBasedOnCuisine(CuisineType.POLISH).size() == 1);
		assertEquals(2, api.getLunchesBasedOnCuisine(CuisineType.ITALIAN).size());
		assertEquals(1, api.getLunchesBasedOnCuisine(CuisineType.MEXICAN).size());
	}
	
	@Test
	public void getAllDrinksTest() {
		assertTrue(api.getAllDrinks().size()==2);
	}
	
}
