package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "lunch")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lunch {

	@XmlAttribute(name = "lunchId")
	private long lunchId;
	@XmlAttribute(name = "cuisine")
	private CuisineType cuisine;
	@XmlElement(name = "dishes")
	private List<Meal> dishes;
	@XmlElement(name = "dessert")
	private Meal dessert;


	public long getLunchId() {
		return lunchId;
	}

	public void setLunchId(long lunchId) {
		this.lunchId = lunchId;
	}

	public CuisineType getCuisine() {
		return cuisine;
	}

	public void setCuisine(CuisineType cuisine) {
		this.cuisine = cuisine;
	}

	public List<Meal> getDishes() {
		return dishes;
	}

	public void setDishes(List<Meal> dishes) {
		this.dishes = dishes;
	}

	public Meal getDessert() {
		return dessert;
	}

	public void setDessert(Meal dessert) {
		this.dessert = dessert;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Lunch of cuisine=" + cuisine + ", dishes:\n");
		dishes.stream().map(d -> d.getName() + ":" + d.getPrice() + "\n").forEach(d -> output.append(d));
		output.append("dessert=" + dessert.getName() + ":" + dessert.getPrice());
		return output.toString();
	}

	public static String getOrderedInfo(String id) {
		return "You order a lunch with Id:" + id;
	}

}
