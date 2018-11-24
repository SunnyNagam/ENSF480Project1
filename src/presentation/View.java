package presentation;

import java.util.ArrayList;

import data.Document;

public interface View{
	public void display();
	public void update();
	public void setUserType(char _ut);
	
	public void updateData(ArrayList<Object> arr);
}
