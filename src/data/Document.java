package data;

import java.util.ArrayList;
import java.util.Iterator;

//a document can be a book, newspaper, journal, or any other type- it will just have null values
public class Document {
	private final Integer ISBN; //unique for each TYPE of book, not individual book
	private final ArrayList<String> authors;	//the authors
	private Integer stock;	//how much is available
	private final String title;	//the document title
	private final Integer version;	//for textbook
	private final Integer edition;	//for newspaper
	private final String contents;	//the stuff in the thing
	private boolean available;
	
	public Document(Integer num, ArrayList<String> authors, Integer stock, String title, Integer version, Integer edition, String contents) {
		this.ISBN = num;
		this.authors = authors;
		this.stock = stock;
		this.title = title;
		this.version = version;
		this.edition = edition;
		this.contents = contents;
		this.available = true;
	}
	public Document(Integer num, String authors, Integer stock, String title, Integer version, Integer edition, String contents) {
		this.ISBN = num;
		this.authors = new ArrayList<String>();
		this.authors.add(authors);
		this.stock = stock;
		this.title = title;
		this.version = version;
		this.edition = edition;
		this.contents = contents;
		this.available = true;
	}
	@Override
	public String toString() {
		String s = String.format("%s%s%s%s%s", 
				getISBN(), getTitle(), getEdition(), getVersion(), getStock());
		return s;
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
		
		return s + "\t";
	}
	
	/*
	 * formats the stock t0 0-9 then 10+
	 */
	public final String getStock() {
		return (stock < 10) ? String.format("%1d\t",stock) :  "10+\t";	// wow fancy 
	}

	public final String getTitle() {
		return (title == null)? "\t" : title + "\t";
	}

	public final String getVersion() {
		return (version==null)? "" : String.valueOf(version) + "\t";
	}

	public final String getEdition() {
		return (edition==null)? "" : String.valueOf(edition) + "\t";
	}

	public final String getContents() {
		return contents;
	}
//	__________________________
	
//	Setters
//	__________________________
	public void toggleAvailability() { 
		this.available = !this.available; 
	}
	
	public void decrementStock(int _numSold) {
		stock -= _numSold;
	}
//	__________________________
		
//	Static
//	__________________________
	public static Document example() {
		return new Document(0,new ArrayList<String>(), 0,"",0,0,"");
		
	}
}
