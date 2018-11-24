package data;

import java.util.ArrayList;

public class DocumentCatalog {
	private ArrayList<Document> documents;	//the list of documents in the DB
	
	@SuppressWarnings("unchecked")
	public DocumentCatalog(ArrayList<?> documents) {
		this.documents = (ArrayList<Document>) documents;
	}
	
	public void addDocument(Document aDocument) {
		documents.add(aDocument);
	}
	
	public void removeDocument(Document aDocument) {
		documents.remove(aDocument);
	}
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	
}
