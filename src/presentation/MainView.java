package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.Controller;

public class MainView extends JFrame{
	private View views[];
	public View currentView;		// getter?
	public JPanel panel;
	private Controller controller;
	public HashMap<String, Integer> pageInd;
	
	public MainView(String s, Controller c) {
		super(s);
		controller = c;
		
		pageInd = new HashMap<String, Integer>();
		
		setBackground(new Color(204, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(860,440) );	//660x240	//100, 100, 650, 600
		
		currentView = LoginPage.getLoginPage(c);
		this.setTitle("Publishing System!");
		
		panel = new JPanel();
		panel.add((Component) currentView);
		add(panel);	// sketchy af
		
		//getRootPane().setDefaultButton(loginPanel.submitButton);
	}
	
	public void init() {
		// setup the panels
		// don't they have to be different if you're a shopper/registered/operator/etc....? YIKES
		// switch to homepage or whatever
		
		// this is temporary and wrong!
		// add pages names and panels for appropriate "user"
		
		views = new View[3];
		
		views[0] = new HomePage();
		pageInd.put("HomePage", 0);
		
		views[1] = new StorePage();
		pageInd.put("StorePage", 1);
		
		views[2] = new ManagementPage();
		pageInd.put("ManagementPage", 2);
		
		// -------------
	}
	
	public View[] getViews() {
		return views;
	}

	public void switchWindow(String page) {
		int index = pageInd.get(page);			// note that if page is not contained this returns null and since null is a 0 it'll go to the homepage, this can either be a bug or a feature depending on how you look at it
		if (index >= 0 && index < views.length) {
			
			currentView = views[index];
			
			this.setTitle(page);
			
			panel.removeAll();
			panel.add((Component) currentView);
			System.out.println("Switched to " + index);
			//this.pack();
			this.paintAll(this.getGraphics());
		}
	}
}
