package data;

import database.DBManager;
import database.DataBaseManager;
import database.DocumentDBManager;

public class StartUp {

	private static DocumentCatalog theDocumentCatalog;
	private static DBManager documentDB;
	private static void loadCourseCatalog() {
		documentDB = new DocumentDBManager();
		theDocumentCatalog = new DocumentCatalog(documentDB.getObjects());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting program...");
		loadCourseCatalog();
		Controller controller = new Controller(theDocumentCatalog);
	}

	

}
