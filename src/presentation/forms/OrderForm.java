package presentation.forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Document;
import data.Payment;
import data.User;


public class OrderForm extends JPanel implements Form {

	JPanel addDocumentForm;
	public JTextField addressBox, creditCardBox, secNumBox, quantityBox, docTitleBox, priceBox;
	
	public JCheckBox giftBox; 
	public JButton submitButton, backButton;
	
	
	@Override
	public void loadForm() {
		this.removeAll();
	setLayout(new BorderLayout());
		
		addDocumentForm = new JPanel();
		addDocumentForm.setLayout( new BoxLayout(addDocumentForm,BoxLayout.Y_AXIS) );
		addDocumentForm.add(new JLabel("Enter your information to buy this book."));

		addressBox 		= new JTextField(15);
		docTitleBox		= new JTextField(15);
		docTitleBox.setEditable(false);
		
		priceBox		= new JTextField(15);
		priceBox.setEditable(false);
		
		creditCardBox 	= new JTextField(15);
		secNumBox 		= new JTextField(15);
		quantityBox 	= new JTextField(15);
		giftBox 		= new JCheckBox();
		
		giftBox.setSelected(true);
		
		submitButton 	= new JButton("Purchase");
		backButton 		= new JButton("Cancel");
		
		addInputBox(docTitleBox,	 	"Ordering  ");
		addInputBox(priceBox,			   "Price  ");
		
		addDocumentForm.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		addInputBox(addressBox,			 "Address  ");
		addInputBox(creditCardBox, "Credit Card #  ");
		addInputBox(secNumBox,		    	 "CVV  ");
		
		addDocumentForm.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		addInputBox(quantityBox,		"Quantity  ");
		addInputBox(giftBox,		   	   "Gift?  ");

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
		int num; 
		Double price;
		//try-catches gaurd agaisnt yikes input, everything else should be checked by controller or DB
		try {
			num = Integer.valueOf(quantityBox.getText());
		} catch (Exception e) {
			num = 1;
		}
		try {
			price = Double.valueOf(priceBox.getText());
		} catch (Exception e) {
			price = 12.99;
		}
		
		Payment p = new Payment(creditCardBox.getText(), num*price, new Date(), null, docTitleBox.getText(), num);
		
		return p;

	}

	@Override
	public void displayResults(String something) {
		// TODO Auto-generated method stub

	}
	private void addInputBox(Component p, String name) {
		JPanel temp = new JPanel();
		temp.setLayout(new BoxLayout(temp,BoxLayout.X_AXIS));
		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100,12));
		temp.add(label);
		temp.add(p);

		addDocumentForm.add(temp);
	}
	@Override
	public void sendData(Object obj) {
		try {
			Document d = (Document) obj;
			quantityBox 	.setText("1");
			docTitleBox 	.setText(d.getTitle());
			priceBox		.setText( String.valueOf(d.getPrice()) );
		} catch(Exception e) {
			System.out.println("nice try.... in Doc section");
		}
		try {
			User usr = (User) obj;
			addressBox 		.setText(usr.address);
			creditCardBox 	.setText(usr.getCC());
			secNumBox 		.setText(usr.cvv);
		} catch(Exception e) {
			System.out.println("nice try.... in User section");
		}

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
