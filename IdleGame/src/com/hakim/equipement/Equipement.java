package com.hakim.equipement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.hakim.Main;
import com.hakim.item.Item;
import com.hakim.item.RuneDmg;

public class Equipement {
	public JButton btnEquipement1;
	public JButton btnEquipement2;
	
	public JButton btnDelete;
	public JButton btnUnequipe;
	
	public JLabel itemDescription;

	public static int slotNbSelected;
	
	public Equipement() {
		
		EquipementHandler equipHandler = new EquipementHandler();
		
		btnEquipement1 = new JButton("1");
		btnEquipement1.setBackground(Color.decode("#827575"));
		btnEquipement1.setFocusPainted(false);
		btnEquipement1.addActionListener(equipHandler);
		btnEquipement1.setActionCommand("equip1");
		
		btnEquipement2 = new JButton("2");
		btnEquipement2.setBackground(Color.decode("#827575"));
		btnEquipement2.setFocusPainted(false);
		btnEquipement2.addActionListener(equipHandler);
		btnEquipement2.setActionCommand("equip2");
		
		btnDelete = new JButton("DELETE");
		btnUnequipe = new JButton("UNEQUIPE");
		
		itemDescription = new JLabel();
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				

				if(Main.scene.hero.equipedItem[slotNbSelected].stats1 == "A") {
					Main.scene.hero.setDmg(Main.scene.hero.getDmg() - Main.scene.hero.equipedItem[slotNbSelected].stats1Value);
				} else if(Main.scene.hero.equipedItem[slotNbSelected].stats1 == "C") {
					Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() - Main.scene.hero.equipedItem[slotNbSelected].stats1Value);
				} else if(Main.scene.hero.equipedItem[slotNbSelected].stats1 == "I") {
					Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() - Main.scene.hero.equipedItem[slotNbSelected].stats1Value);
				}
				Main.scene.hero.equipedItem[slotNbSelected]= new Item();
				Main.scene.showDetailItem = false;	
				itemDescription.setText(null);
				deleteIcon();
			}
		});
		
		btnUnequipe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int equipSlot = 0;
				while(Main.scene.hero.itemInInventory[equipSlot].name != "" && equipSlot < 9) {
					equipSlot++;
				}
				
				if(Main.scene.hero.itemInInventory[equipSlot].name == "") {
					Main.scene.hero.itemInInventory[equipSlot] = Main.scene.hero.equipedItem[slotNbSelected];
					
					if(Main.scene.hero.equipedItem[slotNbSelected].stats1 == "A") {
						Main.scene.hero.setDmg(Main.scene.hero.getDmg() - Main.scene.hero.equipedItem[slotNbSelected].stats1Value);
					} else if(Main.scene.hero.equipedItem[slotNbSelected].stats1 == "C") {
						Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() - Main.scene.hero.equipedItem[slotNbSelected].stats1Value);
					} else if(Main.scene.hero.equipedItem[slotNbSelected].stats1 == "I") {
						Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() - Main.scene.hero.equipedItem[slotNbSelected].stats1Value);
					}
					Main.scene.hero.equipedItem[slotNbSelected] = new Item();
				}	
				itemDescription.setText(null);
				Main.scene.hero.equipedItem[slotNbSelected]= new Item();
				deleteIcon();
				Main.scene.showDetailItem = false;
			}
			
		});
	}
	
	public static void unequipe(int slotNb) {
		int inventarySlot = 0;
		while(Main.scene.hero.itemInInventory[inventarySlot].name != "" && inventarySlot < 9) {
			inventarySlot++;
		}
		if(Main.scene.hero.itemInInventory[inventarySlot].name == "") {
			
			Main.scene.hero.itemInInventory[inventarySlot] = Main.scene.hero.equipedItem[slotNb];
			
			Main.scene.hero.setDmg(Main.scene.hero.getDmg() - Main.scene.hero.equipedItem[slotNb].dmg);
		
			Main.scene.hero.equipedItem[slotNb] = new RuneDmg();
			
			if(slotNb == 0) {
				Main.equipement.btnEquipement1.setIcon(null);
			} else if( slotNb == 1) {
				Main.equipement.btnEquipement2.setIcon(null);
			}
		} else {
			System.out.println("pas de place dans l'inventaire");
		}
		
	}
	

	public void deleteIcon() {
		switch(slotNbSelected) {
		case 0: 
			btnEquipement1.setIcon(null);
			break;
		case 1:
			btnEquipement2.setIcon(null);
			break;
	
		}
	}
	
}
