package com.epam.Faust_Ihor.entity;

/**
 * An abstract class, that represents common items which are used for writing
 * (like pens or pencils)
 * 
 * @author Ihor_Faust
 *
 */
public abstract class WritingItem extends WritingGood {

	private final String colour;
	
	public WritingItem(String title, double price, String color) {
		super(title, price);
		this.colour = color;
	}
	
	public String getColor() {
		return colour;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
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
		WritingItem other = (WritingItem) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WritingItem [colour=" + colour + "]";
	}
	
	public abstract long code();
	
}
