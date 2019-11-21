package api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.CuisineType;
import model.Drink;
import model.Lunch;
import model.Menu;
import model.Order;

public class OrderFoodAPIImpl implements OrderFoodAPI {

	@Override
	public Order createOrder() {
		// TODO can be added in future
		return null;
	}

	private Object getElementsFromXML() {
		File xmlFile = new File("menu.xml");

		JAXBContext jaxbContext ;
		try {
			jaxbContext = JAXBContext.newInstance(Menu.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Lunch> getLunchesBasedOnCuisine(CuisineType cuisineType) {
		List<Lunch> result = new ArrayList<>();
		Menu menu = new Menu();
		if(getElementsFromXML()!=null) {
			menu = (Menu) getElementsFromXML();
			result.addAll(menu.getLunches().stream().filter(i -> i.getCuisine() == cuisineType)
					.collect(Collectors.toList()));
		}
		
		return result;
	}

	@Override
	public List<Drink> getAllDrinks() {
		List<Drink> result = new ArrayList<Drink>();
		Menu drinks = new Menu();
		if(getElementsFromXML()!=null) {
			drinks = (Menu) getElementsFromXML();
			result.addAll(drinks.getDrinks());
		}
		
		return result;
	}

}
