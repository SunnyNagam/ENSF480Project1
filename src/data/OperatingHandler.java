package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.ManagementPage;
import presentation.StorePage;
import presentation.View;

public class OperatingHandler implements Handler{

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setupButtons(View view, Controller controller) {
		
		ManagementPage gui = (ManagementPage) view;
		gui.backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.switchTo("Home");
			}
		});

		gui.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add button pressed");
			}
		});
		
		gui.editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("edit button pressed");
			}
		});
		
		gui.deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete button pressed");
			}
		});
	}
	
}
