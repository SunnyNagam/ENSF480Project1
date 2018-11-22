package presentation;

import data.User;

public interface View{
	public char userType = User.UnregisteredBuyer;
	
	public void display();
	public void update();
}
