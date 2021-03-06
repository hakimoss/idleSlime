package com.hakim.inventory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.hakim.Main;
import com.hakim.item.Item;

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
	
	public JButton btnDelete;
	public JButton btnEquipe;
	
	public JLabel itemDescription;

	public static int slotNbSelected;

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
		
		
		btnDelete = new JButton("DELETE");
		btnEquipe = new JButton("EQUIPE");
		
		itemDescription = new JLabel();
	
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				Main.scene.hero.itemInInventory[slotNbSelected]= new Item();

				Main.scene.showDetailItem = false;	
				itemDescription.setText(null);
				deleteIcon();
			}
		});
		
		btnEquipe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(Main.scene.hero.itemInInventory[slotNbSelected].name) {		
				case "PW":
					System.out.println("health avant : "+Main.scene.hero.getHealth());
					Main.scene.hero.setHealth(Main.scene.hero.getHealth() + 10);
					System.out.println("health apres : "+Main.scene.hero.getHealth());
					Main.scene.hero.itemInInventory[slotNbSelected].name = "";
					break;
				case "PG":
					System.out.println("health avant : "+Main.scene.hero.getHealth());
					Main.scene.hero.setHealth(Main.scene.hero.getHealth() + 20);
					System.out.println("health apres : "+Main.scene.hero.getHealth());
					Main.scene.hero.itemInInventory[slotNbSelected].name = "";
					break;
				case "PB":
					System.out.println("health avant : "+Main.scene.hero.getHealth());
					Main.scene.hero.setHealth(Main.scene.hero.getHealth() + 30);
					System.out.println("health apres : "+Main.scene.hero.getHealth());
					Main.scene.hero.itemInInventory[slotNbSelected].name = "";
					break;
				case "PP":
					System.out.println("health avant : "+Main.scene.hero.getHealth());
					Main.scene.hero.setHealth(Main.scene.hero.getHealth() + 60);
					System.out.println("health apres : "+Main.scene.hero.getHealth());
					Main.scene.hero.itemInInventory[slotNbSelected].name = "";
					break;
				case "PO":
					System.out.println("health avant : "+Main.scene.hero.getHealth());
					Main.scene.hero.setHealth(Main.scene.hero.getHealth() + 100);
					System.out.println("health apres : "+Main.scene.hero.getHealth());
					Main.scene.hero.itemInInventory[slotNbSelected].name = "";
					break;
				case "RDW":
					int equipSlot = 0;
					System.out.println(Main.scene.hero.itemInInventory[slotNbSelected].stats1);
					while(Main.scene.hero.equipedItem[equipSlot].name != "" && equipSlot < 1) {
						equipSlot++;
					}
					if(Main.scene.hero.equipedItem[equipSlot].name == "") {
						Main.scene.hero.equipedItem[equipSlot] = Main.scene.hero.itemInInventory[slotNbSelected];

						if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "A") {
							Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "C") {
							Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "I") {
							Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						}
						
						Main.scene.hero.itemInInventory[slotNbSelected] = new Item();
					}	
					break;
				case "RDG":
					int equipSlot2 = 0;
					while(Main.scene.hero.equipedItem[equipSlot2].name != "" && equipSlot2 < 1) {
						equipSlot2++;
					}
					if(Main.scene.hero.equipedItem[equipSlot2].name == "") {
						Main.scene.hero.equipedItem[equipSlot2] = Main.scene.hero.itemInInventory[slotNbSelected];

						if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "A") {
							Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "C") {
							Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "I") {
							Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						}						
						Main.scene.hero.itemInInventory[slotNbSelected] = new Item();
					}	
					break;
				case "RDB":
					int equipSlot3 = 0;
					while(Main.scene.hero.equipedItem[equipSlot3].name != "" && equipSlot3 < 1) {
						equipSlot3++;
					}
					if(Main.scene.hero.equipedItem[equipSlot3].name == "") {
						Main.scene.hero.equipedItem[equipSlot3] = Main.scene.hero.itemInInventory[slotNbSelected];
						
						
						if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "A") {
							Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "C") {
							Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "I") {
							Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						}						
						Main.scene.hero.itemInInventory[slotNbSelected] = new Item();
					}	
					break;
				case "RDP":
					int equipSlot4 = 0;
					while(Main.scene.hero.equipedItem[equipSlot4].name != "" && equipSlot4 < 1) {
						equipSlot4++;
					}
					if(Main.scene.hero.equipedItem[equipSlot4].name == "") {
						Main.scene.hero.equipedItem[equipSlot4] = Main.scene.hero.itemInInventory[slotNbSelected];
						
						
						if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "A") {
							Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "C") {
							Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "I") {
							Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						}						
						Main.scene.hero.itemInInventory[slotNbSelected] = new Item();
					}	
					break;
				case "RDO":
					int equipSlot5 = 0;
					while(Main.scene.hero.equipedItem[equipSlot5].name != "" && equipSlot5 < 1) {
						equipSlot5++;
					}
					if(Main.scene.hero.equipedItem[equipSlot5].name == "") {
						Main.scene.hero.equipedItem[equipSlot5] = Main.scene.hero.itemInInventory[slotNbSelected];
						
						
						if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "A") {
							Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "C") {
							Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						} else if(Main.scene.hero.itemInInventory[slotNbSelected].stats1 == "I") {
							Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() + Main.scene.hero.itemInInventory[slotNbSelected].stats1Value);
						}						
						Main.scene.hero.itemInInventory[slotNbSelected] = new Item();
					}	
					break;
				case "":
					System.out.println("item vide rien ne se passe !");
					break;
				}
				itemDescription.setText(null);
				Main.scene.hero.itemInInventory[slotNbSelected]= new Item();
				deleteIcon();
				Main.scene.showDetailItem = false;
			}
			
		});
	}
	
	public void deleteIcon() {
		switch(slotNbSelected) {
		case 0: 
			btnInventory1.setIcon(null);
			break;
		case 1:
			btnInventory2.setIcon(null);
			break;
		case 2:
			btnInventory3.setIcon(null);
			break;
		case 3:
			btnInventory4.setIcon(null);
			break;
		case 4:
			btnInventory5.setIcon(null);
			break;
		case 5:
			btnInventory6.setIcon(null);
			break;
		case 6:
			btnInventory7.setIcon(null);
			break;
		case 7:
			btnInventory8.setIcon(null);
			break;
		case 8:
			btnInventory9.setIcon(null);
			break;
		case 9:
			btnInventory10.setIcon(null);
			break;
			
		}
	}
	

	
}
