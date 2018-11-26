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
				((AddDocForm)controller.mainView.formloader.getForm()).titleBox.setEditable(true);
			}
		});
		
		gui.editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("edit button pressed");
				//get selected doc
				Document d = gui.catalogueList.getSelectedValue();
				System.out.println("Selected : " + d);
				
				controller.loadForm("AddDoc");
				setupUpdateFormButtons(controller.mainView.formloader.getForm(), controller);
				((AddDocForm)controller.mainView.formloader.getForm()).clear();
				controller.mainView.formloader.getForm().sendData(d);
				//so it can still be found by title
				((AddDocForm)controller.mainView.formloader.getForm()).titleBox.setEditable(false);
				// this is weid and always updates late after a click and idk whats happnin with it
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
				System.out.println( (Document)theForm.getData()  + "   Added");
				c.update(Constants.addDoc, theForm.getData());
				c.switchTo("Management");
				c.mainView.currentView.updateData(c.theDocuments.getCatalogue());
			}
		});
		
		form.backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.switchTo("Management");
				c.mainView.currentView.updateData(c.theDocuments.getCatalogue());
			}
		});
	}
	public void setupUpdateFormButtons(Form theForm, Controller c) {
		AddDocForm form = (AddDocForm) theForm;
		
		form.submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( (Document)theForm.getData() + "   Updated");
				c.update(Constants.updateDoc, theForm.getData());
				c.switchTo("Management");
				c.mainView.currentView.updateData(c.theDocuments.getCatalogue());
			}
		});
		
		form.backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.switchTo("Management");
				c.mainView.currentView.updateData(c.theDocuments.getCatalogue());
			}
		});
	}

}
