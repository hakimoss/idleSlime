package com.hakim.logIn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hakim.Main;
import com.hakim.Profil;

public class LogIn {
	
	
	public void createAccount(Profil p) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/idleslim", "root", "");
			PreparedStatement ps = conn.prepareStatement("insert into account(email,password,name,stage,dmg,dmgAvantEquip,critChance,critDmg,health,healthRegen,defence,gold,selectedHero,slimHerbe,slimFeu,slimEau) value(?,?,?,1,2,2,1,1,1,1,1,0,?,0,0,0)");
			ps.setString(1, p.getEmail());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getName());
			ps.setString(4, null);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean CheckEmailExists(String email) {
		boolean emailExists = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/idleslim", "root", "");
			PreparedStatement ps = conn.prepareStatement("select * from account where email=?");
			
			ps.setString(1, email);
			ResultSet r1=ps.executeQuery();
	        String emailCounter;
	        if(r1.next()) {
	        	emailCounter =  r1.getString("email");
	           if(emailCounter.equals(email)) {
	               System.out.println("It already exists");
	               emailExists = true;
	           }
	        }
		} catch (SQLException e) {e.printStackTrace();}
		return emailExists;
	}
	
	public boolean getAccount(Profil p) throws ClassNotFoundException,
    SQLException {
		boolean connectedbool = false;
		
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/idleslim", "root", "");
			ps = conn.prepareStatement("select * from account where email=? and password = ?");
			ps.setString(1, p.getEmail());
			ps.setString(2, p.getPassword());
			rs = ps.executeQuery();
			  if(rs.next()) {
	              connectedbool = true;
	              
	              Main.scene.hero.setHealth(rs.getInt("health")*10+90);
	              Main.scene.hero.setHealthLvl(rs.getInt("health"));
	              Main.scene.hero.setHealthRegen(rs.getInt("healthRegen"));
	              Main.scene.hero.setDefence(rs.getInt("defence"));
	              Main.scene.hero.setDmg(rs.getInt("dmgAvantEquip"));
	              Main.scene.hero.setDmgAvantEquip(rs.getInt("dmgAvantEquip"));
	              Main.scene.hero.setCritChance(rs.getInt("critChance"));
	              Main.scene.hero.setCritDmg(rs.getInt("critDmg"));
	              Main.scene.hero.setGold(rs.getInt("gold"));
	              Main.scene.hero.setEmail(rs.getString("email"));
	              Main.scene.hero.setStageMax(rs.getInt("stage"));
	              Main.scene.hero.setPlayerName(rs.getString("name"));
	              Main.scene.hero.setLastUpdate(rs.getLong("lastUpdate"));
	              Main.scene.hero.setSelectedHero(rs.getString("selectedHero"));
	              Main.scene.hero.setSlimHerbe(rs.getBoolean("slimHerbe"));
	              Main.scene.hero.setSlimFeu(rs.getBoolean("slimFeu"));
	              Main.scene.hero.setSlimEau(rs.getBoolean("slimEau"));

	              loadItem(rs.getString("inventory1"), 0);
	              loadItem(rs.getString("inventory2"), 1);
	              loadItem(rs.getString("inventory3"), 2);
	              loadItem(rs.getString("inventory4"), 3);
	              loadItem(rs.getString("inventory5"), 4);
	              loadItem(rs.getString("inventory6"), 5);
	              loadItem(rs.getString("inventory7"), 6);
	              loadItem(rs.getString("inventory8"), 7);
	              loadItem(rs.getString("inventory9"), 8);
	              loadItem(rs.getString("inventory10"), 9);
	              
	              loadEquip(rs.getString("equip1"), 0);
	              loadEquip(rs.getString("equip2"), 1);
	     
	              Main.scene.hero.setDmg(rs.getInt("dmgAvantEquip") + Main.scene.hero.equipedItem[0].dmg + Main.scene.hero.equipedItem[1].dmg);
   
	              Main.scene.stage = Main.scene.hero.getStageMax();
	              if(Main.scene.hero.getStageMax() == 10) {
	            	  Main.scene.setGolem();
	            	  Main.scene.tabEnemi.clear();
	              } else {
	            	  Main.scene.setMonster();
	              }
	          }
	          else {

	              System.out.println("Value not found");
	              connectedbool = false;
	          }
				while (rs.next()) {
					System.out.println("Name=" + rs.getString("name") + ",email="
		                    + rs.getString("email") + ",password="
		                    + rs.getString("password"));	
			}
		} finally {
            if (rs != null)
                rs.close();
            ps.close();
            conn.close();
        }
		
		return connectedbool;
	}
	
	public void saveAccount(Profil p) throws ClassNotFoundException,
    SQLException {
		
		Connection conn = null;
        PreparedStatement ps = null;
        long start = System.currentTimeMillis();
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/idleslim", "root", "");
			ps = conn.prepareStatement("update account set stage = ?, health = ?, healthRegen = ?, defence = ?, dmg = ?, dmgAvantEquip = ?, critChance = ?, critDmg = ?, gold = ?, lastUpdate = ?, selectedHero = ?, inventory1 = ?, inventory2 = ?, inventory3 = ?, inventory4 = ?, inventory5 = ?, inventory6 = ?, inventory7 = ?, inventory8 = ?, inventory9 = ?, inventory10 = ?, equip1 = ?, equip2 = ? where email = ?");
			ps.setInt(1, p.getStage());
			ps.setInt(2, p.getHealth());
			ps.setInt(3, p.getHealthRegen());
			ps.setInt(4, p.getDefence());
			ps.setInt(5, p.getDmg());
			ps.setInt(6, p.getDmgAvantEquip());
			ps.setInt(7, p.getCritChance());
			ps.setInt(8, p.getCritDmg());
			ps.setInt(9, p.getGold());
			ps.setLong(10, start);
			ps.setString(11, Main.scene.hero.getSelectedHero());
			
			saveItem(0, 12, ps);
			saveItem(1, 13, ps);
			saveItem(2, 14, ps);
			saveItem(3, 15, ps);
			saveItem(4, 16, ps);
			saveItem(5, 17, ps);
			saveItem(6, 18, ps);
			saveItem(7, 19, ps);
			saveItem(8, 20, ps);
			saveItem(9, 21, ps);
			
			saveEquip(0, 22, ps);
			saveEquip(1, 23, ps);
		
			ps.setString(24, p.getEmail());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadItem(String item, int inventoryNum) {
		if(item != null) {
			int indexCharactere = 5;
			int indexValue = 0;
			String value = "";
			while(indexCharactere > 0) {
				if(indexCharactere == 1) {
					indexValue = 1;
				} else if (indexCharactere == 2) {
					indexValue = -2;					
				} else if(indexCharactere == 3) {
					indexValue = -5;				
				} else if(indexCharactere == 4) {
					indexValue = -8;				
				} else if(indexCharactere == 5) {
					indexValue = -11;			
					
				}
		
				if(item.startsWith("RDW")) {
					Main.scene.hero.itemInInventory[inventoryNum].name = "RDW";
					if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

	      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
	      			  	
					  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
						  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
		      			  		switch(indexCharactere) {
		      			  		case 5:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
	      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
		    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	} else {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
			      			  	switch(indexCharactere) {
		      			  		case 5:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
		  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
		    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	}
					  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
						  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
		      			  		switch(indexCharactere) {
		      			  		case 5:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
	      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
		    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	} else {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
			      			  	switch(indexCharactere) {
		      			  		case 5:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
		      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
		  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
		    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
			  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	}
					  }
		  	  	} else if(item.startsWith("RDG")) {
		  	  	Main.scene.hero.itemInInventory[inventoryNum].name = "RDG";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("RDB")) {
		  	  	Main.scene.hero.itemInInventory[inventoryNum].name = "RDB";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("RDP")) {
		  	  	Main.scene.hero.itemInInventory[inventoryNum].name = "RDP";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("RDO")) {
		  	  	Main.scene.hero.itemInInventory[inventoryNum].name = "RDO";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
      			  		case 5:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
      			  			break;
	      			  	case 4:
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "A";
      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
      			  			break;
	      			  	case 3:
  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "A";
    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
    			  			break;
		      			case 2:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "A";
	  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "C";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "C";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "C";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
	      			  		case 5:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2 = "I";
	      			  			Main.scene.hero.itemInInventory[inventoryNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
	  			  				Main.scene.hero.itemInInventory[inventoryNum].stats3 = "I";
	    			  			Main.scene.hero.itemInInventory[inventoryNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5 = "I";
		  			  			Main.scene.hero.itemInInventory[inventoryNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("P")) {
		  	  		if(item.startsWith("PW")) {
		        		 Main.scene.hero.itemInInventory[inventoryNum].name = "PW";
		        	} else if(item.startsWith("PG")) {
		        		 Main.scene.hero.itemInInventory[inventoryNum].name = "PG";
		        	} else if (item.startsWith("PB")) {
		        		 Main.scene.hero.itemInInventory[inventoryNum].name = "PB";
		        	} else if(item.startsWith("PP")) {
		        		 Main.scene.hero.itemInInventory[inventoryNum].name = "PP";
		        	} else if(item.startsWith("PO")) {
		        		Main.scene.hero.itemInInventory[inventoryNum].name = "PO";
		        	}
			 	}
				indexCharactere--;
			}
		}	      
    }
      		


	public void loadEquip(String item, int equipNum) {
		if(item != null) {
			int indexCharactere = 5;
			int indexValue = 0;
			String value = "";
			while(indexCharactere > 0) {
				if(indexCharactere == 1) {
					indexValue = 1;
				} else if (indexCharactere == 2) {
					indexValue = -2;					
				} else if(indexCharactere == 3) {
					indexValue = -5;				
				} else if(indexCharactere == 4) {
					indexValue = -8;				
				} else if(indexCharactere == 5) {
					indexValue = -11;					
				}
				
				if(item.startsWith("RDW")) {
					Main.scene.hero.equipedItem[equipNum].name = "RDW";
					if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

	      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
	      			  		case 5:
	      			  			System.out.println("bonne !");
	      			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	      			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	      			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
      			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
	    			  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
	      			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	      			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 4:
	      			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	      			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	      			  			break;
		      			  	case 3:
    			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
	    			  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
	    			  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
	      			  	
					  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
						  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
		      			  		switch(indexCharactere) {
			      			  	case 5:
		      			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		      			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		      			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
	      			  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
		    			  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
			  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
			  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	} else {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
			      			  	switch(indexCharactere) {
			      			  	case 5:
		      			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		      			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		      			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
	      			  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
		    			  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
			  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
			  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	}
					  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
						  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
		      			  		switch(indexCharactere) {
			      			  	case 5:
		      			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		      			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		      			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
	      			  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
		    			  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
			  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
			  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	} else {
		      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
		      			  		if(value.startsWith("0")) {
		      			  			value = value.substring(1);
		      			  		}
			      			  	switch(indexCharactere) {
			      			  	case 5:
		      			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		      			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 4:
		      			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		      			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		      			  			break;
			      			  	case 3:
	      			  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
		    			  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
		    			  			break;
				      			case 2:
			  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
			  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
			  			  			break;
				      			case 1:
			  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
			  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
			  			  			break;
		      			  		}
		      			  	}
					  }
		  	  	} else if(item.startsWith("RDG")) {
		  	  	Main.scene.hero.equipedItem[equipNum].name = "RDG";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("RDB")) {
		  	  	Main.scene.hero.equipedItem[equipNum].name = "RDB";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("RDP")) {
		  	  	Main.scene.hero.equipedItem[equipNum].name = "RDP";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} else if(item.startsWith("RDO")) {
		  	  	Main.scene.hero.equipedItem[equipNum].name = "RDO";
				if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("A")) {

      			  	if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
      			  		switch(indexCharactere) {
	      			  	case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	} else {
      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
      			  		if(value.startsWith("0")) {
      			  			value = value.substring(1);
      			  		}
	      			  	switch(indexCharactere) {
	      				case 5:
	  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 4:
	  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
	  			  			break;
	      			  	case 3:
			  				Main.scene.hero.equipedItem[equipNum].stats3 = "A";
				  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
				  			break;
		      			case 2:
	  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
	  			  			break;
		      			case 1:
	  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "A";
	  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
	  			  			break;
      			  		}
      			  	}
      			  	
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("C")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "C";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "C";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  } else if(item.substring(item.lastIndexOf("/") - indexCharactere).startsWith("I")) {
					  if(item.substring(item.lastIndexOf("-") + indexValue).length() > 2) {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
	      			  		switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	} else {
	      			  		value = item.substring(item.lastIndexOf("-") + indexValue).substring(0, 2);
	      			  		if(value.startsWith("0")) {
	      			  			value = value.substring(1);
	      			  		}
		      			  	switch(indexCharactere) {
		      			  	case 5:
		  			  			Main.scene.hero.equipedItem[equipNum].stats1 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats1Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 4:
		  			  			Main.scene.hero.equipedItem[equipNum].stats2 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats2Value = Integer.parseInt(value);
		  			  			break;
		      			  	case 3:
				  				Main.scene.hero.equipedItem[equipNum].stats3 = "I";
					  			Main.scene.hero.equipedItem[equipNum].stats3Value = Integer.parseInt(value);
					  			break;
			      			case 2:
		  			  			Main.scene.hero.equipedItem[equipNum].stats4 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats4Value = Integer.parseInt(value);
		  			  			break;
			      			case 1:
		  			  			Main.scene.hero.equipedItem[equipNum].stats5 = "I";
		  			  			Main.scene.hero.equipedItem[equipNum].stats5Value = Integer.parseInt(value);
		  			  			break;
	      			  		}
	      			  	}
				  }
		  	  	} 
				indexCharactere--;
			}

			/*
      	  if(item.startsWith("RD")) {
          	  if(item.startsWith("RDW")) {
          		  if(item.substring(item.lastIndexOf("/") - 3).startsWith("DMG")) {
          			  Main.scene.hero.equipedItem[equipNum] = new RuneDmg("RDW", "white", Integer.parseInt(item.substring(item.lastIndexOf("/") + 1)));
          			  Main.scene.hero.equipedItem[equipNum].dmg = Integer.parseInt(item.substring(item.lastIndexOf("/") + 1));
          		  }
          	  } else if(item.startsWith("RDG")) {
          		  if(item.substring(item.lastIndexOf("/") - 3).startsWith("DMG")) {
          			  Main.scene.hero.equipedItem[equipNum] = new RuneDmg("RDG", "green", Integer.parseInt(item.substring(item.lastIndexOf("/") + 1)));
          			  Main.scene.hero.equipedItem[equipNum].dmg = Integer.parseInt(item.substring(item.lastIndexOf("/") + 1));
          		  }
          	  } else if(item.startsWith("RDB")) {
          		  if(item.substring(item.lastIndexOf("/") - 3).startsWith("DMG")) {
          			  Main.scene.hero.equipedItem[equipNum] = new RuneDmg("RDB", "blue", Integer.parseInt(item.substring(item.lastIndexOf("/") + 1)));
          			  Main.scene.hero.equipedItem[equipNum].dmg = Integer.parseInt(item.substring(item.lastIndexOf("/") + 1));
          		  }
          	  } else if(item.startsWith("RDP")) {
          		  if(item.substring(item.lastIndexOf("/") - 3).startsWith("DMG")) {
          			  Main.scene.hero.equipedItem[equipNum] = new RuneDmg("RDP", "purple", Integer.parseInt(item.substring(item.lastIndexOf("/") + 1)));
          			  Main.scene.hero.equipedItem[equipNum].dmg = Integer.parseInt(item.substring(item.lastIndexOf("/") + 1));
          		  }
          	  } else if(item.startsWith("RDO")) {
          		  if(item.substring(item.lastIndexOf("/") - 3).startsWith("DMG")) {
          			  Main.scene.hero.equipedItem[equipNum] = new RuneDmg("RDO", "orange", Integer.parseInt(item.substring(item.lastIndexOf("/") + 1)));
          			  Main.scene.hero.equipedItem[equipNum].dmg = Integer.parseInt(item.substring(item.lastIndexOf("/") + 1));
          		  }
          	  }
            }
      	  */
			
			
			
        }
	}

	public void saveItem(int num1, int num2, PreparedStatement ps) {
		if(Main.scene.hero.itemInInventory[num1].name != "") {
			String stats1 = Main.scene.hero.itemInInventory[num1].stats1;
			String stats2 = Main.scene.hero.itemInInventory[num1].stats2;
			String stats3 = Main.scene.hero.itemInInventory[num1].stats3;
			String stats4 = Main.scene.hero.itemInInventory[num1].stats4;
			String stats5 = Main.scene.hero.itemInInventory[num1].stats5;
			if(stats1 == null) {stats1 = "N";}
			if(stats2 == null) {stats2 = "N";}
			if(stats3 == null) {stats3 = "N";}
			if(stats4 == null) {stats4 = "N";}
			if(stats5 == null) {stats5 = "N";}
			
			String statsValue1 = String.format("%02d", Main.scene.hero.itemInInventory[num1].stats1Value);
			String statsValue2 = String.format("%02d", Main.scene.hero.itemInInventory[num1].stats2Value);
			String statsValue3 = String.format("%02d", Main.scene.hero.itemInInventory[num1].stats3Value);
			String statsValue4 = String.format("%02d", Main.scene.hero.itemInInventory[num1].stats4Value);
			String statsValue5 = String.format("%02d", Main.scene.hero.itemInInventory[num1].stats5Value);
			
			System.out.println(""+Main.scene.hero.itemInInventory[num1].name+"/"+stats1+stats2+stats3+stats4+stats5+"/"+statsValue1+"-"+statsValue2+"-"+statsValue3+"-"+statsValue4+"-"+statsValue5);

			try {
				ps.setString(num2, ""+Main.scene.hero.itemInInventory[num1].name+"/"+stats1+stats2+stats3+stats4+stats5+"/"+statsValue1+"-"+statsValue2+"-"+statsValue3+"-"+statsValue4+"-"+statsValue5);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				ps.setString(num2, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void saveEquip(int num1, int num2, PreparedStatement ps) {
		if(Main.scene.hero.equipedItem[num1].name != "") {
			String stats1 = Main.scene.hero.equipedItem[num1].stats1;
			String stats2 = Main.scene.hero.equipedItem[num1].stats2;
			String stats3 = Main.scene.hero.equipedItem[num1].stats3;
			String stats4 = Main.scene.hero.equipedItem[num1].stats4;
			String stats5 = Main.scene.hero.equipedItem[num1].stats5;
			if(stats1 == null) {stats1 = "N";}
			if(stats2 == null) {stats2 = "N";}
			if(stats3 == null) {stats3 = "N";}
			if(stats4 == null) {stats4 = "N";}
			if(stats5 == null) {stats5 = "N";}
			
			String statsValue1 = String.format("%02d", Main.scene.hero.equipedItem[num1].stats1Value);
			String statsValue2 = String.format("%02d", Main.scene.hero.equipedItem[num1].stats2Value);
			String statsValue3 = String.format("%02d", Main.scene.hero.equipedItem[num1].stats3Value);
			String statsValue4 = String.format("%02d", Main.scene.hero.equipedItem[num1].stats4Value);
			String statsValue5 = String.format("%02d", Main.scene.hero.equipedItem[num1].stats5Value);
			try {
				ps.setString(num2, ""+Main.scene.hero.equipedItem[num1].name+"/"+stats1+stats2+stats3+stats4+stats5+"/"+statsValue1+"-"+statsValue2+"-"+statsValue3+"-"+statsValue4+"-"+statsValue5);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				ps.setString(num2, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
