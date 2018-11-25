package data;

import java.util.ArrayList;

public class DocumentCatalog {
	private ArrayList<Document> documents;	//the list of documents in the DB
	private ArrayList<String> promotions;	//the list of promotions in the DB
	
	@SuppressWarnings("unchecked")
	public DocumentCatalog(ArrayList<Document> documents, ArrayList<String> promotions) {
		this.documents = documents;
		this.promotions = promotions;
	}
	
	public void addDocument(Document aDocument) {
		documents.add(aDocument);
	}
	public void addPromoDocument(Document aDocument) {
		promotions.add(aDocument.getTitle());
	}
	public void removeDocument(Document aDocument) {
		documents.remove(aDocument);
	}
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	
	public ArrayList<Object> getPromotions() {
		ArrayList<Object> temp = new ArrayList<Object>();
		temp.addAll(promotions);
		return temp;
	}
	
}
