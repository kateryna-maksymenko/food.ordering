package main;

import api.OrderFoodAPI;
import api.OrderFoodAPIImpl;
import model.CuisineType;
import model.Drink;
import model.Lunch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static OrderFoodAPI api;

	public static void main(String[] args)  {
		Scanner keyboard = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("Please make your choice:\n 1:Lunch\n 2:Drink");
			String input = keyboard.nextLine();
			if ("2".equals(input)) {
				orderDrink(keyboard);
				System.out.println("Do you want order a lunch?: Y/N \n ");
				String isLunchNeeded = keyboard.nextLine();
				if ("N".equalsIgnoreCase(isLunchNeeded)) {
					exit = true;
				} else if ("Y".equalsIgnoreCase(isLunchNeeded)) {
					orderLunch(keyboard);
				}
			} else if ("1".equals(input)) {
				orderLunch(keyboard);

				System.out.println("Do you want drink something?: Y/N \n ");
				String isDrinkOrdered = keyboard.nextLine();
				if ("N".equalsIgnoreCase(isDrinkOrdered)) {
					exit = true;
				} else if ("Y".equalsIgnoreCase(isDrinkOrdered)) {
					orderDrink(keyboard);
				}

			}
			exit = true;
		}
		keyboard.close();
	}

	public static void orderDrink(Scanner keyboard) {
		List<Drink> drinks = getApi().getAllDrinks();
		System.out.println("Please input id of drink: \n ");
		drinks.forEach(l -> System.out.println(l.toString()));
		String drinkId = keyboard.nextLine();
		System.out.println("Do you want ice cubes or lemon?:\n 1:Ice cubes\n 2:Lemon\n 3:Nothing!");
		String isAdditionalServiceNeeded = keyboard.nextLine();
		if ("2".equals(isAdditionalServiceNeeded)) {
			System.out.println("You order a lemon");
		} else if ("1".equals(isAdditionalServiceNeeded)) {
			System.out.println("You order ice cubes.");
		}
		System.out.println(Drink.getOrderedInfo(drinkId));
	}

	public static void orderLunch(Scanner keyboard) {
		System.out.println("Please choose a cuisine: \n ");
		Arrays.asList(CuisineType.values()).stream().map(e -> e.ordinal() + ":" + e.toString())
				.forEach(e -> System.out.println(e));
		String cuisineInput = keyboard.nextLine();
		if (cuisineInput != null) {
			List<Lunch> lunches = getApi()
					.getLunchesBasedOnCuisine(CuisineType.values()[Integer.valueOf(cuisineInput)]);
			lunches.stream().map(l -> l.getLunchId() + ":" + l.toString()).forEach(l -> System.out.println(l));
			System.out.println("Please input id of lunch: \n ");
			String lunchId = keyboard.nextLine();
			System.out.println(Lunch.getOrderedInfo(lunchId));
		}
	}

	public static OrderFoodAPI getApi() {
		if (api == null) {
			api = new OrderFoodAPIImpl();
		}
		return api;
	}

}
