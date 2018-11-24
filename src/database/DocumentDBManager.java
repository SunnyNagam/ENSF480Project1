package database;

import java.util.ArrayList;
import java.util.HashMap;

import data.Document;
import data.User;

public class DocumentDBManager implements DBManager {

	HashMap<Integer, Document> documentDataBase;	//ISBN hashed to document
	
	public DocumentDBManager() {
		documentDataBase = new HashMap<Integer, Document>();
		ArrayList<String> authors123 = new ArrayList<String>();
		String contents123 = "This story is really amazing it's about disneyland, which is the"
				+ "greatest place on earth for happiness";
		authors123.add("John C Riley");
		authors123.add("Mickey Mouse");
		documentDataBase.put(123, new Document(123, authors123, 3, "Disneyland", 1, 1, contents123));
		
	}
	
	@Override
	public Document checkDocument(int key) {
		Document theDocument;
			if ((theDocument = documentDataBase.get(key)) != null)
			{
				
				return theDocument;
			}
		
		return null;
	}

	@Override
	public User checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
