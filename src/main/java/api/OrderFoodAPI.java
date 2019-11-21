package api;

import java.util.List;

import model.CuisineType;
import model.Drink;
import model.Lunch;
import model.Order;

public interface OrderFoodAPI {

	// TODO:
	Order createOrder();

	List<Lunch> getLunchesBasedOnCuisine(CuisineType cuisineType);

	List<Drink> getAllDrinks();
}
