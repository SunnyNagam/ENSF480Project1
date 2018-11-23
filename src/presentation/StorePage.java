package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument.Iterator;

import data.User;

public class StorePage extends JPanel implements View{
	public JButton searchButton, registerButton, promotionsButton, backButton;
	public boolean showingPromotions = false;
	public JScrollPane promotionsPane;
	public HashMap<String, String> promotionsData;		// TODO get from database
	public JPanel mainPanel;
	
	public StorePage() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
				
		mainPanel = new JPanel();
		mainPanel.add(new JLabel("StorePage Test"));
		mainPanel.add(new JLabel("Stuff"));
				
		add(mainPanel, BorderLayout.CENTER);
		
		//buttons from here
		
		
		DefaultListModel<String> promotions = new DefaultListModel<String>();
		JList<String> promotionsList = new JList<String> (promotions);
		promotionsList.setFont(new Font("menlo",Font.PLAIN,12));
		
		promotionsData = new HashMap<String,String>();
		promotionsData.put("Yikes Patel, a hero's jouney.", "$12.99");
		promotionsData.put("LouJeep McJeep, making of a criminal.", "$34.99");
		promotionsData.put("KeenBeen, Pimp ur audio rig to a gaudio rig.", "$99.99");
		
		for (Map.Entry<String, String> entry : promotionsData.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    
		    promotions.addElement((key+" "+value));
		}
		
		promotionsPane = new JScrollPane(promotionsList);
		//promotionsPane.setPreferredSize(new Dimension(300,200));
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void togglePromotions() {
		if(showingPromotions) {
			remove(promotionsPane);
			add(mainPanel, BorderLayout.CENTER);
		}
		else {
			remove(mainPanel);
			add(promotionsPane, BorderLayout.CENTER);
		}
		
		showingPromotions = !showingPromotions;
		this.paintAll(this.getGraphics());
		//this.repaint();
	}
	public char userType;
	@Override 
	public void setUserType(char _ut) {
		userType = _ut;
		
		//button moved to here
		JPanel botPan = new JPanel();
		botPan.add(searchButton = new JButton("Search"));
		
		if (_ut != User.UnregisteredBuyer)
			botPan.add(promotionsButton = new JButton("View Promotions"));
		else
			botPan.add(registerButton = new JButton("Register"));
		
		botPan.add(backButton = new JButton("Back"));
		
		add(botPan, BorderLayout.PAGE_END);
		
	}
}
