package com.epam.Faust_Ihor.entity;

/**
 * An abstract class, representing the most common properties of goods for
 * writing.
 * 
 * @author Ihor_Faust
 *
 */
public abstract class WritingGood {

	/*The name-on-the-box of the good*/
	private String title;
	
	private double price;

	public WritingGood(){}

	public WritingGood(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WritingGood other = (WritingGood) obj;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WritingGood [title=" + title + ", price=" + price + "]";
	}
	
	public abstract long code();
}
