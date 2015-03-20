package com.epam.Faust_Ihor.entity;

/**
 * A class which represents pen properties.
 * 
 * @author Ihor_Faust
 *
 */
public class Pen extends WritingItem {

	final private String type;
	
	public Pen(String title, double price, String color, String type){
		super(title, price, color);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Pen [type=" + type + ", code()=" + code() + ", getColor()="
				+ getColor() + ", getTitle()=" + getTitle() + ", getPrice()="
				+ getPrice() + "]";
	}

	public long code(){
		final int prime = 31;
		long result = prime + 1 * getTitle().hashCode();
		result = prime + result * getColor().hashCode();
		result = prime + result * type.hashCode();
		return result + Integer.MAX_VALUE;
	}

}
