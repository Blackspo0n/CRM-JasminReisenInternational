package crm.JasminReisen.Listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.SpecEntryFrame;

public class SpecEntryFrameListener implements ActionListener
{
	SpecEntryFrame frame;
	
	public SpecEntryFrameListener(SpecEntryFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		
        if(frame.getBox().getSelectedIndex() == 1 && event.getSource() == frame.getSend())
				{
        		DbFunctions.createSpec(frame, "Regionen (RegionenName)");
				frame.getEntry().setText("");
				frame.getBox().setSelectedIndex(0);
				}
        else if(frame.getBox().getSelectedIndex() == 2 && event.getSource() == frame.getSend())
        	{
    		DbFunctions.createSpec(frame, "Klima (KlimaBeschreibung)");
			frame.getEntry().setText("");
			frame.getBox().setSelectedIndex(0);
			}
        else if(frame.getBox().getSelectedIndex() == 3 && event.getSource() == frame.getSend())
        	{
    		DbFunctions.createSpec(frame, "Themen (ThemenName)");
			frame.getEntry().setText("");
			frame.getBox().setSelectedIndex(0);
			}
       
        else if (frame.getBox().getSelectedIndex() == 4 && event.getSource() == frame.getSend())
        	{
    		DbFunctions.createSpec(frame, "Transportmittel (TransportName)");
			frame.getEntry().setText("");
			frame.getBox().setSelectedIndex(0);
			}
        
		 else if(event.getSource() == frame.getReset())
				{
			 	frame.getEntry().setText("");
				frame.getBox().setSelectedIndex(0);
				}
		}
	}
