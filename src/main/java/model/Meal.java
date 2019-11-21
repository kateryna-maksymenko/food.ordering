package model;

public class Meal {
	
    private String name;

    private double price;
    

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

	@Override
	public String toString() {
		return "name=" + name + ", price=" + price;
	}

	
    
    
}
