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
			PreparedStatement ps = conn.prepareStatement("insert into account(email,password,name,stage,dmg,health,gold,selectedHero) value(?,?,?,1,2,0,0,?)");
			ps.setString(1, p.getEmail());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getName());
			ps.setString(4, null);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	              System.out.println("Success");
	              connectedbool = true;
	              
	              Main.scene.hero.setHealth(rs.getInt("health")*20+100);
	              Main.scene.hero.setHealthLvl(rs.getInt("health"));
	              Main.scene.hero.setDmg(rs.getInt("dmg"));
	              Main.scene.hero.setGold(rs.getInt("gold"));
	              Main.scene.hero.setEmail(rs.getString("email"));
	              Main.scene.hero.setStageMax(rs.getInt("stage"));
	              Main.scene.hero.setPlayerName(rs.getString("name"));
	              Main.scene.hero.setLastUpdate(rs.getLong("lastUpdate"));
	              Main.scene.hero.setSelectedHero(rs.getString("selectedHero"));
	              
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
			ps = conn.prepareStatement("update account set stage = ?, health = ?, dmg = ?, gold = ?, lastUpdate = ?, selectedHero = ? where email = ?");
			ps.setInt(1, p.getStage());
			ps.setInt(2, p.getHealth());
			ps.setInt(3, p.getDmg());
			ps.setInt(4, p.getGold());
			ps.setLong(5, start);
			ps.setString(6, Main.scene.hero.getSelectedHero());
			ps.setString(7, p.getEmail());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}