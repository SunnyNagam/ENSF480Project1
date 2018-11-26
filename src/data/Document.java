package data;

import java.util.ArrayList;
import java.util.Iterator;

//a document can be a book, newspaper, journal, or any other type- it will just have null values
public class Document {
	private Integer ISBN; //unique for each TYPE of book, not individual book
	private ArrayList<String> authors;	//the authors
	private Integer stock;	//how much is available
	private final String title;	//the document title
	private Integer version;	//for textbook
	private Integer edition;	//for newspaper
	private String contents;	//the stuff in the thing
	private boolean available;
	public boolean promotional;
	private double price;
	private Document() {
		this.ISBN = null;
		this.authors = null;
		this.title = null;
		this.version = null;
		this.edition = null;
		this.contents = null;
	}
	
	public Document(Integer num, ArrayList<String> authors, Integer stock, String title, Integer version, Integer edition, String contents, double p) {
		this.ISBN = num;
		this.authors = authors;
		this.stock = stock;
		this.title = title;
		this.version = version;
		this.edition = edition;
		this.contents = contents;
		this.available = true;
		this.price = p;
	}
	public Document(Integer num, String authors, Integer stock, String title, Integer version, Integer edition, String contents, double p) {
		this.ISBN = num;
		this.authors = new ArrayList<String>();
		this.authors.add(authors);
		this.stock = stock;
		this.title = title;
		this.version = version;
		this.edition = edition;
		this.contents = contents;
		this.available = true;
		this.price = p;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@SuppressWarnings("unchecked")
	public void copy(Document other) {
		this.ISBN 			= other.ISBN;
		this.authors 		= (ArrayList<String>) other.authors.clone();
		this.stock 			= other.stock;
		this.version 		= other.version;
		this.edition 		= other.edition;
		this.contents 		= other.contents;
		this.available 		= other.available;
		this.promotional 	= other.promotional;
	}
	@Override
	public String toString() {
		String s = String.format("%-10s  %-20s  %-4s  %-4s  %-4s  %-20s  %-4f",
				getISBN(), getTitle(), getEdition(), getVersion(), getStock(), getAuthors(), getPrice());
		return s;
	}
	@Override
	public boolean equals(Object d) throws ClassCastException{
		Document other = (Document) d;
		if (this.ISBN == other.ISBN && this.contents.equals(other.contents))
			return true;
		else
			return false;
	}
//	Getters
//	__________________________
	public final boolean isVisible() { 
		return this.available; 
	}
	
	public final int maxPurchase() {
		return stock;
	}
	
	public final String getISBN() {
		return String.format("%d", ISBN);
	}

	public final String getAuthors() {
		String s = "";
		Iterator<String> i = authors.iterator();
		while (i.hasNext())
			s += i.next() + (i.hasNext()? ", ": "");
		
		return s;
	}
	
	/*
	 * formats the stock t0 0-9 then 10+
	 */
	public final String getStock() {
		return (stock < 10) ? String.format("%1d",stock) :  "10+";	// wow fancy 
	}
	public final String getTrueStock() {
		return String.valueOf(stock);
	}

	public final String getTitle() {
		return (title == null)? "N/A" : title ;
	}

	public final String getVersion() {
		return (version==null)? "N/A" : String.valueOf(version);
	}

	public final String getEdition() {
		return (edition==null)? "N/A" : String.valueOf(edition);
	}

	public final String getContents() {
		return contents;
	}
//	__________________________
	
//	Setters
//	__________________________
	public void Available(boolean a) { 
		this.available = a; 
	}
	
	public void decrementStock(int _numSold) {
		stock -= _numSold;
	}
//	__________________________
		
//	Static
//	__________________________
	public static Document example() {
		return new Document(0,new ArrayList<String>(), 0,"",0,0,"",0.0);
		
	}
	public static Document title() {
		//Yeesh this is really extra
		Document titleDoc = new Document() {
			@Override
			public String toString() {	
				String s = String.format("%-10s  %-20s  %-4s  %-4s  %-4s  %-20s", 
				"ISBN", "Title", "ed.", "ver", "cps.", "Authors");
				return s;
			}
		};
		return titleDoc;
	}
}
