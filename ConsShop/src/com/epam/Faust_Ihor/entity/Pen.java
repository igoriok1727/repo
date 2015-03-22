package com.epam.Faust_Ihor.entity;

/**
 * A class which represents pen properties.
 * 
 * @author Ihor_Faust
 *
 */
public class Pen extends WritingItem {

    final private PenType type;

    public Pen(String title, double price, String color, PenType type) {
	super(title, price, color);
	if (title == null || color == null || type == null) {
	    throw new NullPointerException();
	}
	this.type = type;
    }

    public PenType getType() {
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
	return "Pen [title=" + getTitle() + ", price=" + getPrice() + ", color="
		+ getColor() + ", type=" + type + ", code="
		+ code() + "]";
    }

    public long code() {
	final int prime = 31;
	int result = getTitle().hashCode();
	result = prime + result * getColor().hashCode();
	result = prime + result * type.hashCode();
	return (long) result + Integer.MAX_VALUE;
    }

}
