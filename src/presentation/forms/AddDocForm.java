package presentation.forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Document;


public class AddDocForm extends JPanel implements Form {

	JPanel addDocumentForm;
	public JTextField isbnBox, titleBox, authorsBox, 
			versionBox, editionBox, stockBox, contentsBox;
	
	public JCheckBox availableBox,promoBox; 
	public JButton submitButton, backButton;
	
	
	@Override
	public void loadForm() {
	setLayout(new BorderLayout());
		
		addDocumentForm = new JPanel();
		addDocumentForm.setLayout( new BoxLayout(addDocumentForm,BoxLayout.Y_AXIS) );
		addDocumentForm.add(new JLabel("Enter your infromation to register."));

		isbnBox 		= new JTextField(15);
		titleBox 		= new JTextField(15);
		authorsBox 		= new JTextField(15);
		versionBox 		= new JTextField(15);
		editionBox 		= new JTextField(15);
		stockBox 		= new JTextField(15);
		contentsBox 	= new JTextField(30);
		availableBox 	= new JCheckBox();
		availableBox.setSelected(true);
		promoBox 	= new JCheckBox();
		promoBox.setSelected(true);
		
		submitButton 	= new JButton("Submit");
		backButton 		= new JButton("Cancel");
		
		addInputBox(isbnBox,		"ISBN   ");
		addInputBox(titleBox,		"Title  ");
		addInputBox(authorsBox,		"Authors");
		addInputBox(versionBox,		"Version");
		addInputBox(editionBox,		"Edition");
		addInputBox(stockBox,		"Stock  ");
		addInputBox(contentsBox,	"Content");
		addInputBox(availableBox,	"Visible");

		addDocumentForm.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		add(addDocumentForm, BorderLayout.CENTER);
		
		JPanel bot = new JPanel();
		bot.setLayout(new BoxLayout(bot,BoxLayout.X_AXIS));
		
		bot.add(submitButton);
		bot.add(backButton);
		
		addDocumentForm.add(bot, BorderLayout.PAGE_END);

	}

	@Override
	public Object getData() {
		Integer isbn, version, edition, stock;
		//try-catches gaurd agaisnt yikes input, everything else should be checked by controller or DB
		try {
			isbn = Integer.valueOf(isbnBox.getText());
		} catch (Exception e) {
			isbn = null;
		}
		try {
			stock = Integer.valueOf(stockBox.getText());
		} catch (Exception e) {
			stock = 0;
		}
		try {
			version = Integer.valueOf(versionBox.getText());
		} catch (Exception e) {
			version = null;
		}
		try {
			edition = Integer.valueOf(editionBox.getText());
		} catch (Exception e) {
			edition = null;
		}
		
		ArrayList<String> authors = new ArrayList<String>
			(Arrays.asList(authorsBox.getText().split(",")));
		
		String title, content;
		
		title = titleBox.getText();
		content = contentsBox.getText();
		
		Document d = new Document(isbn, authors, stock, title, version, edition, content);
		
		d.Available( availableBox.isSelected() );
		d.promotional = promoBox.isSelected();
		
		return d;
	}

	@Override
	public void displayResults(String something) {
		// TODO Auto-generated method stub

	}
	private void addInputBox(Component p, String name) {
		JPanel temp = new JPanel();
		temp.setLayout(new BoxLayout(temp,BoxLayout.X_AXIS));
		
		temp.add(new JLabel(name));
		temp.add(p);
		//janky add promo button
		if (name.equals("Visible")) {
			temp.add(new JLabel("Promotional"));
			temp.add(promoBox);
		}
		
		addDocumentForm.add(temp);
	}

}
