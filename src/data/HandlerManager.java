package data;

import java.util.HashMap;

import presentation.View;

public class HandlerManager {
	private Handler handlers[];
	HashMap<String, Integer> handlerInd;
	
	public User user;
	
	Controller controller;
	
	public Handler currentHandler;
	
	public HandlerManager(Controller c, User u) {
		this.controller = c;
		this.user = u;
		
		handlerInd = new HashMap<String, Integer>();
		handlers = new Handler[3];
		// setup handlers based on user???? if we don't have time lets just make it the same and throw an error saying users arent authorized for operating actions or something 
		handlers[0] = new HomeHandler();
		handlerInd.put("HomeHandler", 0);
		
		handlers[1] = new StoreHandler();
		handlerInd.put("StoreHandler", 1);
		
		handlers[2] = new OperatingHandler();
		handlerInd.put("ManagementHandler", 2);
		
		//setup buttons and stuff
		View views[] = c.mainView.getViews();
		
		for(int x=0; x<views.length; x++) {
			handlers[x].setupButtons(views[x], controller);		// this is sketch TODO
		}
	}
	
	public void switchHandler(String handle) {
		int index = handlerInd.get(handle);			// note that if page is not contained this returns null and since null is a 0 it'll go to the homepage, this can either be a bug or a feature depending on how you look at it
		
		if (index >= 0 && index < handlers.length) {
			currentHandler = handlers[index];
		}
	}
}
