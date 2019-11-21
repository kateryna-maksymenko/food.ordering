package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="menu")
@XmlAccessorType (XmlAccessType.FIELD)
public class Menu {
	@XmlElement(name="lunch")
	private List<Lunch> lunches = null;
	@XmlElement(name="drink")
	private List<Drink> drinks = null;

	public List<Lunch> getLunches() {
		return lunches;
	}

	public void setLunches(List<Lunch> lunches) {
		this.lunches = lunches;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
	
	

}
