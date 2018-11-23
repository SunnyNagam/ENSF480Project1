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

public class StorePage extends JPanel implements View{
	public JButton searchButton, registerButton, promotionsButton, backButton;
	public boolean showingPromotions = false, showingSearch = false;
	public JScrollPane promotionsPane;
	public HashMap<String, String> promotionsData;		// TODO get from database
	public JPanel mainPanel, searchPanel;
	
	public StorePage() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
				
		mainPanel = new JPanel();
		mainPanel.add(new JLabel("StorePage Test"));
		mainPanel.add(new JLabel("Stuff"));
				
		add(mainPanel, BorderLayout.CENTER);
		
		JPanel botPan = new JPanel();
		botPan.add(searchButton = new JButton("Search"));
		botPan.add(registerButton = new JButton("Register"));
		botPan.add(promotionsButton = new JButton("View Promotions"));
		botPan.add(backButton = new JButton("Back"));
		
		add(botPan, BorderLayout.PAGE_END);
		
		
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
		
		searchPanel = new JPanel();
		searchPanel.add(new JLabel("Search"));
		searchPanel.add(new JLabel("stuff"));
		searchPanel.add(new JButton("Do The thing"));
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.paintAll(this.getGraphics());
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
		update();
		//this.repaint();
	}
	public void toggleSearch() {
		if(showingSearch) {
			remove(searchPanel);
			add(mainPanel, BorderLayout.CENTER);
		}
		else {
			remove(mainPanel);
			add(searchPanel, BorderLayout.CENTER);
		}
		
		showingSearch = !showingSearch;
		update();
	}
}
