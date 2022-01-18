package com.hakim.inventory;

import java.awt.Color;

import javax.swing.JButton;

import com.hakim.Main;
import com.hakim.item.RuneDmg;

public class Inventory {
	public JButton btnInventory1;
	public JButton btnInventory2;
	public JButton btnInventory3;
	public JButton btnInventory4;
	public JButton btnInventory5;
	public JButton btnInventory6;
	public JButton btnInventory7;
	public JButton btnInventory8;
	public JButton btnInventory9;
	public JButton btnInventory10;
	
	public Inventory() {
		InventoryHandler iHandler = new InventoryHandler();

		
		btnInventory1 = new JButton();
		btnInventory1.setBackground(Color.decode("#827575"));
		btnInventory1.setFocusPainted(false);
		btnInventory1.addActionListener(iHandler);
		btnInventory1.setActionCommand("item1");
		
		btnInventory2 = new JButton();
		btnInventory2.setBackground(Color.decode("#827575"));
		btnInventory2.setFocusPainted(false);
		btnInventory2.addActionListener(iHandler);
		btnInventory2.setActionCommand("item2");
		btnInventory3 = new JButton();
		btnInventory3.setBackground(Color.decode("#827575"));
		btnInventory3.setFocusPainted(false);
		btnInventory3.addActionListener(iHandler);
		btnInventory3.setActionCommand("item3");
		btnInventory4 = new JButton();
		btnInventory4.setBackground(Color.decode("#827575"));
		btnInventory4.setFocusPainted(false);
		btnInventory4.addActionListener(iHandler);
		btnInventory4.setActionCommand("item4");
		btnInventory5 = new JButton();
		btnInventory5.setBackground(Color.decode("#827575"));
		btnInventory5.setFocusPainted(false);
		btnInventory5.addActionListener(iHandler);
		btnInventory5.setActionCommand("item5");
		btnInventory6 = new JButton();
		btnInventory6.setBackground(Color.decode("#827575"));
		btnInventory6.setFocusPainted(false);
		btnInventory6.addActionListener(iHandler);
		btnInventory6.setActionCommand("item6");
		btnInventory7 = new JButton();
		btnInventory7.setBackground(Color.decode("#827575"));
		btnInventory7.setFocusPainted(false);
		btnInventory7.addActionListener(iHandler);
		btnInventory7.setActionCommand("item7");
		btnInventory8 = new JButton();
		btnInventory8.setBackground(Color.decode("#827575"));
		btnInventory8.setFocusPainted(false);
		btnInventory8.addActionListener(iHandler);
		btnInventory8.setActionCommand("item8");
		btnInventory9 = new JButton();
		btnInventory9.setBackground(Color.decode("#827575"));
		btnInventory9.setFocusPainted(false);
		btnInventory9.addActionListener(iHandler);
		btnInventory9.setActionCommand("item9");
		btnInventory10 = new JButton();
		btnInventory10.setBackground(Color.decode("#827575"));
		btnInventory10.setFocusPainted(false);
		btnInventory10.addActionListener(iHandler);
		btnInventory10.setActionCommand("item10");
	}
	
	public static void itemUsed(int slotNb) {
		switch(Main.scene.hero.itemInInventory[slotNb].name) {
		case "P":
			
			System.out.println("health avant : "+Main.scene.hero.getHealth());
			Main.scene.hero.setHealth(Main.scene.hero.getHealth() + 10);
			System.out.println("health apres : "+Main.scene.hero.getHealth());
			Main.scene.hero.itemInInventory[slotNb].name = "";
			break;
		case "RDW":
			int equipSlot = 0;
			while(Main.scene.hero.equipedItem[equipSlot].name != "" && equipSlot < 1) {
				equipSlot++;
			}
			if(Main.scene.hero.equipedItem[equipSlot].name == "") {
				Main.scene.hero.equipedItem[equipSlot] = Main.scene.hero.itemInInventory[slotNb];
				
				Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNb].dmg);
				
				Main.scene.hero.itemInInventory[slotNb] = new RuneDmg();
			}
			
			break;
		case "":
			System.out.println("item vide rien ne se passe !");
			break;
		}
	}

}
