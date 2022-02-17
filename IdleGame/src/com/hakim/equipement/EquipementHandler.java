package com.hakim.equipement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hakim.Main;




public class EquipementHandler implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		case "equip1":
			//Equipement.unequipe(0);
			Equipement.slotNbSelected = 0;
			Main.scene.showDetailItem = true;
			Main.equipement.btnEquipement1.setIcon(null);
			System.out.println("name : "+Main.scene.hero.equipedItem[0].name);
			switch(Main.scene.hero.equipedItem[0].name) {
			case "RDW":
				if(Main.scene.hero.equipedItem[0].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.equipedItem[0].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.equipedItem[0].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.equipedItem[0].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.equipedItem[0].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[0].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[0].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		case "equip2":
			//Equipement.unequipe(1);
			Equipement.slotNbSelected = 1;
			Main.scene.showDetailItem = true;
			Main.equipement.btnEquipement1.setIcon(null);
			System.out.println("name : "+Main.scene.hero.equipedItem[1].name);
			switch(Main.scene.hero.equipedItem[1].name) {
			case "RDW":
				if(Main.scene.hero.equipedItem[1].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffffff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				}
				break;	
			case "RDG":
				if(Main.scene.hero.equipedItem[1].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#75da5f;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				}
				break;
			case "RDB":
				if(Main.scene.hero.equipedItem[1].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#1383ff;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				}
				break;
			case "RDP":
				if(Main.scene.hero.equipedItem[1].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ee2bc1;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				}
				break;
			case "RDO":
				if(Main.scene.hero.equipedItem[1].stats1 == "A") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "C") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Chance : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				} else if(Main.scene.hero.equipedItem[1].stats1 == "I") {
					Main.equipement.itemDescription.setText("<html><p><span style='color:#ffbc3a;'>Red Rune</span> <br> Crit Damage : "+Main.scene.hero.equipedItem[1].stats1Value+"</p></html>");		
				}
				break;
			}
			break;
		

		}
	}

}
