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


public class OrderForm extends JPanel implements Form {

	JPanel addDocumentForm;
	public JTextField addressBox, creditCardBox, secNumBox, quantityBox, docTitleBox;
	
	public JCheckBox giftBox; 
	public JButton submitButton, backButton;
	
	
	@Override
	public void loadForm() {
		this.removeAll();
	setLayout(new BorderLayout());
		
		addDocumentForm = new JPanel();
		addDocumentForm.setLayout( new BoxLayout(addDocumentForm,BoxLayout.Y_AXIS) );
		addDocumentForm.add(new JLabel("Enter your infromation to register."));

		addressBox 		= new JTextField(15);
		docTitleBox		= new JTextField(15);
		creditCardBox 	= new JTextField(15);
		secNumBox 		= new JTextField(15);
		quantityBox 	= new JTextField(15);
		giftBox 		= new JCheckBox();
		
		giftBox.setSelected(true);
		
		submitButton 	= new JButton("Purchase");
		backButton 		= new JButton("Cancel");
		
		addInputBox(addressBox,		"ISBN   ");
		addInputBox(creditCardBox,	"Title  ");
		addInputBox(secNumBox,		"Authors");
		addInputBox(quantityBox,	"Version");
		addInputBox(giftBox,		"Visible");

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
		Integer version, edition;
		//try-catches gaurd agaisnt yikes input, everything else should be checked by controller or DB
		try {
			version = Integer.valueOf(quantityBox.getText());
		} catch (Exception e) {
			version = null;
		}
		try {
			edition = Integer.valueOf(docTitleBox.getText());
		} catch (Exception e) {
			edition = null;
		}
		
		ArrayList<String> authors = new ArrayList<String>
			(Arrays.asList(secNumBox.getText().split(", ")));
		
//		String title, content;
//		
//		title = creditCardBox.getText();
//		content = contentsBox.getText();
//		
		Document d = new Document(null, authors, null, null, version, edition, null);
//		
//		d.Available( availableBox.isSelected() );
//		d.promotional = promoBox.isSelected();
//		
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
//		//janky add promo button
//		if (name.equals("Visible")) {
//			temp.add(new JLabel("Promotional"));
//			temp.add(promoBox);
//		}
//		
		addDocumentForm.add(temp);
	}
	@Override
	public void sendData(Object obj) {
		try {
		Document d = (Document) obj;
		addressBox 		.setText(d.getISBN());
		creditCardBox 		.setText(d.getTitle());
		secNumBox 		.setText(d.getAuthors());
		quantityBox 		.setText(d.getVersion());
		docTitleBox 		.setText(d.getEdition());
		
		} catch(Exception e) {
			
		}
		//set text
	}

	public void clear() {
		//this is the code of a desperate man
		addressBox 		.setText("");
		creditCardBox 	.setText("");
		secNumBox 		.setText("");
		quantityBox 	.setText("");
		docTitleBox 	.setText("");
	}
}
