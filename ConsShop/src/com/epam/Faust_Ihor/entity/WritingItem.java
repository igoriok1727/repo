package com.epam.Faust_Ihor.entity;

/**
 * An abstract class, that represents common items which are used for writing
 * (like pens or pencils)
 * 
 * @author Ihor_Faust
 *
 */
public abstract class WritingItem extends WritingGood {

	private final String color;
	
	public WritingItem(String title, double price, String color) {
		super(title, price);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WritingItem [colour=" + color + "]";
	}
	
	public abstract long code();
	
}
