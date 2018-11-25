package database;

import java.util.ArrayList;
import java.util.HashMap;

import data.Document;
import data.User;

public class DocumentDBManager implements DBManager {

	HashMap<String, Document> documentDataBase;	//ISBN hashed to document
	public HashMap<String,Document> promotionsData;		//
	
	public DocumentDBManager() {
		documentDataBase = new HashMap<String, Document>();
		ArrayList<String> authors123 = new ArrayList<String>();
		String contents123 = "This story is really amazing it's about disneyland, which is the"
				+ "greatest place on earth for happiness";
		authors123.add("John C Riley");
		authors123.add("Mickey Mouse");
		documentDataBase.put("DisneyLand", new Document(123, authors123, 3, "Disneyland", 1, 1, contents123));
		
		promotionsData = new HashMap<String,Document>();

		//promotionsData.put("Yikes Patel, a hero's jouney.", "$12.99");
		//promotionsData.put("LouJeep McJeep, making of a criminal.", "$34.99");
		//promotionsData.put("KeenBeen, DIY pimp ur audio rig to a gaudio rig.", "$99.99");
	}
	
	@Override
	public Document checkDocument(String key) {
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
  
	// yeesh
	public void updatePromos(boolean add, Document d) {
		if (!add) 
			promotionsData.remove(d.getTitle(), d);
		else
			promotionsData.put(d.getTitle(), d);
	}
  
	@Override
	public ArrayList<Document> getObjects() {
		ArrayList<Document> documents = new ArrayList<Document>();
		documents.addAll(documentDataBase.values());
		documents.add(new Document(100, "SunJeep", 45, "The life of a legend", 2, 4, "What a time to be alive. When I was a young boy my dad told me to treat others how I would like to be treated. I found this impossible because I could never worship everyone at the same time, doesn't even make sence. But that was classic papa patel, another time he told me \"Sunjeep my boy, if you want to win my enternal affection you'll win the 4th NASA childrens Engineering competition for your old man\". I neither wanted or needed my fathers approval at that time. But being the ambitious young sport I was, I decided to go for it. It was the competition of the year, every school's brightest engineers were there. The cream of the crop. To win this would take great determination. I would practice daily for 40 hours, I did a million pushups, a million situps, ran a million miles, and mined bitcoin with my raw brain power alone and a notepad. I was only 7 at the time so this was more difficult than it would of been now. The day of the competition had finally arrived. Luckily for your readers the rest of this story is amazingly short, as I walked into the judgeing room I was instantly greeted with a chorus of cheers. The croud went wild. The engineers offered me first place without any competition. The other contestans needless to say were furious, but once they saw me they instantly understood and quit school altoghether, knowing the rest of thier career would just be living in my shadow. In fact NASA offered me a 4 month internship as one of their lead engineer, unbeknownst to them I would take over as CEO and apolo asternaut during my 4 month internship, ultimately quitting that job because of creative differences."));
		
		return documents;
	}
	
	public ArrayList<String> getPromos() {
		ArrayList<String> documents = new ArrayList<String>();
		documents.addAll(promotionsData.keySet());
		//documents.add(new Document(100, "SunJeep", 45, "The life of a legend", 2, 4, "What a time to be alive. When I was a young boy my dad told me to treat others how I would like to be treated. I found this impossible because I could never worship everyone at the same time, doesn't even make sence. But that was classic papa patel, another time he told me \"Sunjeep my boy, if you want to win my enternal affection you'll win the 4th NASA childrens Engineering competition for your old man\". I neither wanted or needed my fathers approval at that time. But being the ambitious young sport I was, I decided to go for it. It was the competition of the year, every school's brightest engineers were there. The cream of the crop. To win this would take great determination. I would practice daily for 40 hours, I did a million pushups, a million situps, ran a million miles, and mined bitcoin with my raw brain power alone and a notepad. I was only 7 at the time so this was more difficult than it would of been now. The day of the competition had finally arrived. Luckily for your readers the rest of this story is amazingly short, as I walked into the judgeing room I was instantly greeted with a chorus of cheers. The croud went wild. The engineers offered me first place without any competition. The other contestans needless to say were furious, but once they saw me they instantly understood and quit school altoghether, knowing the rest of thier career would just be living in my shadow. In fact NASA offered me a 4 month internship as one of their lead engineer, unbeknownst to them I would take over as CEO and apolo asternaut during my 4 month internship, ultimately quitting that job because of creative differences."));
		
		return documents;
	}

	@Override
	public void addObject(String key, Object obj) {
		// TODO Auto-generated method stub
		documentDataBase.put(key, (Document)obj);
		
	}
}
