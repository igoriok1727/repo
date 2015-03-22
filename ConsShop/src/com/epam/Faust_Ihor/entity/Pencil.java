package com.epam.Faust_Ihor.entity;

/**
 * A class, which represents pencil properties.
 * 
 * @author Ihor_Faust
 *
 */
public class Pencil extends WritingItem {

    private String thickness;

    public Pencil(String title, double price, String color, String thickness) {
	super(title, price, color);
	if (title == null || color == null || thickness == null) {
	    throw new NullPointerException();
	}
	this.thickness = thickness;
    }

    public String getThickness() {
	return thickness;
    }

    public void setThickness(String thickness) {
	this.thickness = thickness;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((thickness == null) ? 0 : thickness.hashCode());
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
	Pencil other = (Pencil) obj;
	if (thickness == null) {
	    if (other.thickness != null)
		return false;
	} else if (!thickness.equals(other.thickness))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Pencil [title=" + getTitle() + ", price=" + getPrice() 
		+ ", color=" + getColor() + ", thickness=" + thickness 
		+ ", code=" + code() + "]";
    }

    public long code() {
	final int prime = 31;
	int result = getTitle().hashCode();
	result = prime + result * getColor().hashCode();
	result = prime + result * thickness.hashCode();
	return (long) result + Integer.MAX_VALUE;
    }

}
