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
			Inventory.slotNbSelected = 0;
			Main.scene.showDetailItem = true;
			Main.inventory.btnInventory1.setIcon(null);
			System.out.println("name : "+Main.scene.hero.itemInInventory[0].name);
			switch(Main.scene.hero.itemInInventory[0].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[0].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[0].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[0].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[0].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[0].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[0].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[0].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item2":
			Inventory.slotNbSelected = 1;
			Main.scene.showDetailItem = true;
			Main.inventory.btnInventory2.setIcon(null);
			switch(Main.scene.hero.itemInInventory[1].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[1].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				}				
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[1].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[1].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[1].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[1].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[1].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[1].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item3":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 2;
			Main.inventory.btnInventory3.setIcon(null);
			switch(Main.scene.hero.itemInInventory[2].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[2].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[2].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[2].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[2].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[2].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[2].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[2].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item4":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 3;
			Main.inventory.btnInventory4.setIcon(null);
			switch(Main.scene.hero.itemInInventory[3].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[3].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[3].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[3].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[3].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[3].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[3].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[3].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item5":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 4;
			Main.inventory.btnInventory5.setIcon(null);
			switch(Main.scene.hero.itemInInventory[4].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[4].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[4].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[4].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[4].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[4].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[4].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[4].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item6":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 5;
			Main.inventory.btnInventory6.setIcon(null);
			switch(Main.scene.hero.itemInInventory[5].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[5].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[5].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[5].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[5].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[5].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[5].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[5].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item7":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 6;
			Main.inventory.btnInventory7.setIcon(null);
			switch(Main.scene.hero.itemInInventory[6].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[6].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[6].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[6].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[6].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[6].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[6].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[6].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item8":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 7;
			Main.inventory.btnInventory8.setIcon(null);
			switch(Main.scene.hero.itemInInventory[7].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[7].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[7].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[7].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[7].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[7].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[7].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[7].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item9":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 8;
			Main.inventory.btnInventory9.setIcon(null);
			switch(Main.scene.hero.itemInInventory[8].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[8].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[8].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[8].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[8].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[8].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[8].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[8].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "item10":
			Main.scene.showDetailItem = true;
			Inventory.slotNbSelected = 9;
			Main.inventory.btnInventory10.setIcon(null);
			switch(Main.scene.hero.itemInInventory[9].name) {
			case "PW":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Potion</span> <br>10 hp</p></html>");				
				break;
			case "PG":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Potion</span> <br>20 hp</p></html>");				
				break;
			case "PB":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Potion</span> <br>30 hp</p></html>");				
				break;
			case "PP":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Potion</span> <br>60 hp</p></html>");				
				break;
			case "PO":
				Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Potion</span> <br>100 hp</p></html>");				
				break;
			case "RDW":
				if(Main.scene.hero.itemInInventory[9].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.itemInInventory[9].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.itemInInventory[9].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.itemInInventory[9].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.itemInInventory[9].stats1 == "A") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "C") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.itemInInventory[9].stats1 == "I") {
					Main.inventory.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.itemInInventory[9].stats1Value+"</p></html>");		
				}
				break;
			}
			break;

		}

		
		
		
	}

}
