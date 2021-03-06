package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import data.User;
import data.Document;
import data.Controller;

public class StorePage extends JPanel implements View{
	public JButton searchButton, registerButton, promotionsButton, backButton;

	
	public boolean showingPromotions = false;
	public JScrollPane promotionsPane;
	DefaultListModel<String> promotions;
	JList<String> promotionsList;
	public JPanel mainPanel;
	
	private ArrayList<String> promos;	
	
	public StorePage() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
				
		mainPanel = new JPanel();
		mainPanel.add(new JLabel("Store"));
				
		add(mainPanel, BorderLayout.CENTER);
		
		//buttons from here
		promos = new ArrayList<String>();
		
		promotions = new DefaultListModel<String>();
		promotionsList = new JList<String> (promotions);
		promotionsList.setFont(new Font("menlo",Font.PLAIN,12));
			
		Iterator<String> entry = promos.iterator();
		while( entry.hasNext() ) {
		    promotions.addElement(entry.next());
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
	public void togglePromotions(ArrayList<Object> promos) {
		if(showingPromotions) {
			remove(promotionsPane);
			add(mainPanel, BorderLayout.CENTER);
			promotionsButton.setText("View promotions");
		}
		else {
			remove(mainPanel);
			updateData(promos);				// observer pattern oh yea baby
			add(promotionsPane, BorderLayout.CENTER);
			promotionsButton.setText("Hide promotions");
		}
		System.out.println(promos.size());
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
		
		if (_ut != User.UnregisteredBuyer ) {
			botPan.add(promotionsButton = new JButton("View Promotions"));
		}
		else {
			botPan.add(registerButton = new JButton("Register"));
		}
		
		botPan.add(backButton = new JButton("Back"));
		
//		//this is being moved to managementpage
		//if (_ut != User.Operator) {
			add(botPan, BorderLayout.PAGE_END);
			return;
		//}
//		// operators only, get here:
//		
//		JPanel topPan = new JPanel();
//		
//		topPan.add(addButton = new JButton("Add"));
//		
//		topPan.add(editButton = new JButton("Edit"));
//		
//		topPan.add(deleteButton = new JButton("Delete"));
//			
//		JPanel p = new JPanel();
//		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
//		
//		p.add(topPan);
//		p.add(new JSeparator(SwingConstants.HORIZONTAL));
//		p.add(botPan);
//		
//		add(p, BorderLayout.PAGE_END);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateData(ArrayList<Object> arr) {
		try {
			promos = (ArrayList<String>) arr.clone();
			promotions.clear();
			promos.forEach(entry -> {
				//if ( entry.isVisible() )
					promotions.addElement(entry.toString());
			});
			//TODO idk if thats all you need to do to update the list contianig promotions
			//maybe update thepromotionsList and promotionsPane here
		} catch (Exception e) {
			System.err.println("Error Updating Store Data...\n" + e.getMessage());
		}
		System.out.println(promotions.size());
	}
}
