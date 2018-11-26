package presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import data.Document;

@SuppressWarnings("serial")
public class ManagementPage extends JPanel implements View{
	public JButton backButton;	//probably shouldn't make these public?
	public JButton addButton, editButton, deleteButton;
	
	JScrollPane storePane;
	DefaultListModel<Document> catalogueModel;
	public JList<Document> catalogueList;
	ArrayList<Document> catalogue;
	
	public ManagementPage() {
		// TODO Auto-generated constructor stub
		JLabel test = new JLabel("This is the window\nfor viewing Documents,\nall of them");
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.add(test);
		
		
		catalogue = new ArrayList<Document>();
		
		catalogueModel = new DefaultListModel<Document>();
		catalogueList = new JList<Document> (catalogueModel);
		catalogueList.setFont(new Font("menlo",Font.PLAIN,12));
			
		Iterator<Document> entry = catalogue.iterator();
		while( entry.hasNext() ) {
			catalogueModel.addElement(entry.next());
		}
		
		storePane = new JScrollPane(catalogueList);
		
		add(storePane,BorderLayout.CENTER);
		
		add(panel, BorderLayout.NORTH);
		buttons();
		
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public char userType;
	@Override 
	public void setUserType(char _ut) {
		userType = _ut;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateData(ArrayList<Object> arr) {
		try {
			catalogue = (ArrayList<Document>) arr.clone();
			catalogueModel.clear();
			catalogue.forEach(entry -> {
				//if ( entry.isVisible() )
				catalogueModel.addElement(entry);
			});
			//TODO idk if thats all you need to do to update the list contianig promotions
			//maybe update thepromotionsList and promotionsPane here
		} catch (Exception e) {
			System.err.println("Error Updating Store Data...\n" + e.getMessage());
		}
	}

	private void buttons () {
		JPanel botPan = new JPanel();
		botPan.add(backButton = new JButton("Back"));

		JPanel topPan = new JPanel();
		
		topPan.add(addButton = new JButton("Add"));
		
		topPan.add(editButton = new JButton("Edit"));
		
		topPan.add(deleteButton = new JButton("Delete"));
			
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		
		p.add(topPan);
		p.add(new JSeparator(SwingConstants.HORIZONTAL));
		p.add(botPan);
		
		add(p, BorderLayout.PAGE_END);
	}
}
