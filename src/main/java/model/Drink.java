package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="drink")
@XmlAccessorType (XmlAccessType.FIELD)
public class Drink extends Meal {
	
	@XmlAttribute(name="id")
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static String getOrderedInfo(String id) {
		return "You order a drink with Id:" + id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + getName() + ", price=" + getPrice();
	}
	
	
}
