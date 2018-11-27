package data;

import java.util.ArrayList;

public class DocumentCatalog {
	private ArrayList<Document> documents;	//the list of documents in the DB
	private ArrayList<String> promotions;	//the list of promotions in the DB
	public long updateTime = System.nanoTime();
	public DocumentCatalog(ArrayList<Document> documents, ArrayList<String> promotions) {
		this.documents = documents;
		this.promotions = promotions;
	}
	
	public void addDocument(Document aDocument) {
		documents.add(aDocument);
	}
	public void addPromoDocument(Document aDocument) {
		System.out.println("adding to promos");
		if(!promotions.contains(aDocument.getTitle()) ) {
			promotions.add(aDocument.getTitle());
		}
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
	public ArrayList<Object> getCatalogue() {
		ArrayList<Object> temp = new ArrayList<Object>();
		temp.addAll(documents);
		return temp;
	}
	public void update(Document d) {

		documents.forEach(doc ->{
			if (doc.getTitle().equals(d.getTitle())){
				doc.copy(d);
				if (d.promotional)
					addPromoDocument(d);
				else
					removePromoDocument(d);
			}
		});

	}

	private void removePromoDocument(Document d) {
		if (promotions.contains(d.getTitle()))
			promotions.remove(d.getTitle());
		
	}

	public void remove(Document d) {
		documents.remove(d);
	}
	//returns true if success
	public boolean purchase(String docTitle, int num) {
		for (Document doc : documents) {
			if (doc.getTitle().equals(docTitle)){
				if (!doc.decrementStock(num) ) return false;
			}
		}
		return true;
	}
}
