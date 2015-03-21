package com.epam.Faust_Ihor.entity;

/**
 * A class, which represents a notebook object.
 * 
 * @author Ihor_Faust
 *
 */
public class Notebook extends WritingGood {

	private final int pageCount;
	
	public Notebook(String title, double price, int pageCount){
		super(title, price);
		this.pageCount = pageCount;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pageCount;
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
		Notebook other = (Notebook) obj;
		if (pageCount != other.pageCount)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Notebook [pageCount=" + pageCount + ", code=" + code()
				+ ", title=" + getTitle() + ", price=" + getPrice()
				+ "]";
	}

	public long code(){
		final int prime = 31;
		long result = prime + 1 * getTitle().hashCode();
		result = prime + result * pageCount;
		return result + Integer.MAX_VALUE;
	}

	

}
