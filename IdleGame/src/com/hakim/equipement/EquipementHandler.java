package com.hakim.equipement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EquipementHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		case "equip1":
			Equipement.unequipe(0);
			break;
		case "equip2":
			Equipement.unequipe(1);
			//Main.equipement.btnEquipement2.setIcon(null);
			break;
		

		}
	}

}