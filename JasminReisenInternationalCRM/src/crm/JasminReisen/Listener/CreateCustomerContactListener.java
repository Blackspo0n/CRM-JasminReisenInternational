package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import crm.JasminReisen.GUI.CreateCustomerContactFrame;
import crm.JasminReisen.models.Kunde;

public class CreateCustomerContactListener implements ActionListener {

	CreateCustomerContactFrame cccf;

	public CreateCustomerContactListener(CreateCustomerContactFrame cccf) {
		this.cccf = cccf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		switch (event.getActionCommand()) 
		{
		
		case "Combo":
			
			
			Kunde kunde = new Kunde();
			kunde = (Kunde) cccf.getCustomerBox().getSelectedItem();
			cccf.getCustomerIdField().setText("" + kunde.getKundennummer() + "");
			break;
			
			
		case "Field":
			
			cccf.getCustomerBox().setActionCommand("temp");
			int i = -1;
			boolean notFound = false;
			Integer custId = Integer.parseInt(cccf.getCustomerIdField().getText());
			
			do 
			{
				i++;
				try 
				{
					cccf.getCustomerBox().setSelectedIndex(i);
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Die ID konnte keinem Kunden zugewiesen werden.");
					notFound = true;
				}
			} 
			while (((Kunde) cccf.getCustomerBox().getSelectedItem()).getKundennummer() != custId && notFound == false);
			
			cccf.getCustomerBox().setActionCommand("Combo");
			break;
		
		case "Abbrechen":
			cccf.dispose();
			break;
			
		case "Speichern":
			
			
			cccf.dispose();
			break;

		}

	}
}
