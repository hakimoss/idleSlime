package com.hakim.equipement;

import java.awt.Color;

import javax.swing.JButton;

import com.hakim.Main;
import com.hakim.item.RuneDmg;

public class Equipement {
	public JButton btnEquipement1;
	public JButton btnEquipement2;
	
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
}
