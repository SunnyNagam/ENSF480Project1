package data;

import java.util.Date;

public class Payment {
	public double amount;
	private String creditCard;
	private User usr;
	public String docTitle;
	public int amountSold;
	
	public String getCreditCard() {
		return creditCard;
	}

	public Date dateTime;
	public Payment (String cc, double amount, Date d, User user, String docTitle, int amountSold) {
		this.amount = amount;
		this.creditCard = cc.trim();
		this.dateTime = (Date) d.clone();
		this.usr = user;
		this.docTitle = docTitle;
		this.amountSold = amountSold;
	}
	
	public String getCC() {
		int len = creditCard.length();
		if (len < 4) return "";
		return String.format("XXXX-XXXX-XXXX-%4s", creditCard.substring(len - 4, len));
	}
	
	public void setUser(User user) {
		usr = user;
	}
}
