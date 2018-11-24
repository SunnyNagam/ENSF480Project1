package data;

import java.util.ArrayList;

//a document can be a book, newspaper, journal, or any other type- it will just have null values
public class Document {
	private final int ISBN; //unique for each TYPE of book, not individual book
	private final ArrayList<String> authors;	//the authors
	private int stock;	//how much is available
	private final String title;	//the document title
	private final int version;	//for textbook
	private final int edition;	//for newspaper
	private final String contents;	//the stuff in the thing
	
	public Document(int num, ArrayList<String> authors, int stock, String title, int version, int edition, String contents) {
		ISBN = num;
		this.authors = authors;
		this.stock = stock;
		this.title = title;
		this.version = version;
		this.edition = edition;
		this.contents = contents;
	}
}
