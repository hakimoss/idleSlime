package com.hakim.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hakim.Main;



public class InventoryHandler implements ActionListener {
	

	

	@Override
	public void actionPerformed(ActionEvent e) {

		String yourChoice = e.getActionCommand();
		
	
		switch(yourChoice) {
		case "item1":
			Inventory.itemUsed(0);
			
			//Main.inventory.btnInventory1.setText("");
			Main.inventory.btnInventory1.setIcon(null);

			break;
		case "item2":
			Inventory.itemUsed(1);
			Main.inventory.btnInventory2.setIcon(null);
			break;
		case "item3":
			Inventory.itemUsed(2);
			Main.inventory.btnInventory3.setIcon(null);
			break;
		case "item4":
			Inventory.itemUsed(3);
			Main.inventory.btnInventory4.setIcon(null);
			break;
		case "item5":
			Inventory.itemUsed(4);
			Main.inventory.btnInventory5.setIcon(null);
			break;
		case "item6":
			Inventory.itemUsed(5);
			Main.inventory.btnInventory6.setIcon(null);
			break;
		case "item7":
			Inventory.itemUsed(6);
			Main.inventory.btnInventory7.setIcon(null);
			break;
		case "item8":
			Inventory.itemUsed(7);
			Main.inventory.btnInventory8.setIcon(null);
			break;
		case "item9":
			Inventory.itemUsed(8);
			Main.inventory.btnInventory9.setIcon(null);
			break;
		case "item10":
			Inventory.itemUsed(9);
			Main.inventory.btnInventory10.setIcon(null);
			break;

		}

		
		
		
	}

}