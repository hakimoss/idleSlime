package com.hakim.item;

import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RuneDmg extends Item {
	public String name;
	public String rarity;
	public int dmg;
	public Image img;
	public int valueGold;
	
	public String stats1;
	public String stats2;
	public String stats3;
	public String stats4;
	public String stats5;
	
	public int stats1Value;
	public int stats2Value;
	public int stats3Value;
	public int stats4Value;
	public int stats5Value;

	public RuneDmg() {
		this.name = "";
		this.rarity = "";
		this.dmg = 0;
		this.stats1 = "";
		this.stats1Value = 0;
	}

	public RuneDmg(String rarity) {
		super(rarity);
		this.rarity = rarity;
		Random rand = new Random(); //instance of random class
		this.stats2 = "N";
		this.stats2Value = 00;
		this.stats3 = "N";
		this.stats3Value = 00;
		this.stats4 = "N";
		this.stats4Value = 00;
		this.stats5 = "N";
		this.stats5Value = 00;
		if(rarity == "white") {
			int upperbound = 3;
			int stats1Value = rand.nextInt(upperbound); 
			int statsChoice = 3;
			int stats1String = rand.nextInt(statsChoice); 
			if(stats1String == 0) {
				this.stats1 = "A";
			} else if (stats1String == 1) {
				this.stats1 = "C";
			} else if (stats1String == 2) {
				this.stats1 = "I";
			}
			this.stats1Value = stats1Value + 1;
			
			this.name = "RDW";
			this.valueGold = 10;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgWhite.png"));
			} catch (IOException e) {e.printStackTrace();}
			
		} else if(rarity == "green") {
			int upperbound = 6;
			int stats1Value = rand.nextInt(upperbound); 
			int statsChoice = 3;
			int stats1String = rand.nextInt(statsChoice); 
			if(stats1String == 0) {
				this.stats1 = "A";
			} else if (stats1String == 1) {
				this.stats1 = "C";
			} else if (stats1String == 2) {
				this.stats1 = "I";
			}
			//this.dmg = stats1Value + 3;
			this.name = "RDG";
			this.valueGold = 20;
			//this.stats1 = statChoice();
			this.stats1Value = stats1Value + 3;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgGreen.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "blue") {
			int upperbound = 10;
			int stats1Value = rand.nextInt(upperbound); 
			int statsChoice = 3;
			int stats1String = rand.nextInt(statsChoice); 
			if(stats1String == 0) {
				this.stats1 = "A";
			} else if (stats1String == 1) {
				this.stats1 = "C";
			} else if (stats1String == 2) {
				this.stats1 = "I";
			}
			//this.dmg = stats1Value + 6;
			this.name = "RDB";
			this.valueGold = 30;
			//this.stats1 = statChoice();
			this.stats1Value = stats1Value + 6;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgBlue.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "purple") {
			int upperbound = 20;
			int stats1Value = rand.nextInt(upperbound); 
			int statsChoice = 3;
			int stats1String = rand.nextInt(statsChoice); 
			if(stats1String == 0) {
				this.stats1 = "A";
			} else if (stats1String == 1) {
				this.stats1 = "C";
			} else if (stats1String == 2) {
				this.stats1 = "I";
			}
			//this.dmg = stats1Value + 10;
			this.name = "RDP";
			this.valueGold = 50;
			//this.stats1 = statChoice();
			this.stats1Value = stats1Value + 10;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgPurple.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "orange") {
			int upperbound = 50;
			int stats1Value = rand.nextInt(upperbound); 
			int statsChoice = 3;
			int stats1String = rand.nextInt(statsChoice); 
			if(stats1String == 0) {
				this.stats1 = "A";
			} else if (stats1String == 1) {
				this.stats1 = "C";
			} else if (stats1String == 2) {
				this.stats1 = "I";
			}
			//this.dmg = stats1Value + 20;
			this.name = "RDO";
			this.valueGold = 100;
			//this.stats1 = statChoice();
			this.stats1Value = stats1Value + 20;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgOrange.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else {
			System.out.println("mauvai choix de rareté");
		}
	}
	
	public RuneDmg(String name, String rarity, String stats1, String stats2, String stats3, String stats4, String stats5, int stats1Value, int stats2Value, int stats3Value, int stats4Value, int stats5Value) {
		super(name, rarity);
		this.name = name;
		this.rarity = rarity;
		
		this.stats1 = stats1;
		this.stats2 = stats2;
		this.stats3 = stats3;
		this.stats4 = stats4;
		this.stats5 = stats5;
		
		this.stats1Value = stats1Value;
		this.stats2Value = stats2Value;
		this.stats3Value = stats3Value;
		this.stats4Value = stats4Value;
		this.stats5Value = stats5Value;
		
		if(rarity == "white") {
			this.valueGold = 10;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgWhite.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "green") {
			this.valueGold = 20;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgGreen.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "blue") {
			this.valueGold = 30;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgBlue.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "purple") {
			this.valueGold = 50;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgPurple.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "orange") {
			this.valueGold = 100;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgOrange.png"));
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	
	
}
