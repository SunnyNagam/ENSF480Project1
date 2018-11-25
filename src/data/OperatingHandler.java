package data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.ManagementPage;
import presentation.View;
import presentation.forms.AddDocForm;
import presentation.forms.Form;

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
				controller.loadForm("AddDoc");
				setupAddFormButtons(controller.mainView.formloader.getForm(), controller);
			}
		});
		
		gui.editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("edit button pressed");
				//get selected doc
				//update inv
			}
		});
		
		gui.deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete button pressed");
				//get selected doc
				//update inv
			}
		});
	}
	
	public void setupAddFormButtons(Form theForm, Controller c) {
		AddDocForm form = (AddDocForm) theForm;
		
		form.submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( (Document)theForm.getData() );
				c.update(Constants.addDoc, theForm.getData());
			}
		});
		
		form.backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.switchTo("Management");
			}
		});
	}
}
