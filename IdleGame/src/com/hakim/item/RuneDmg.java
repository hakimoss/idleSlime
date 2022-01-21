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

	public RuneDmg() {
		this.name = "";
		this.rarity = "";
		this.dmg = 0;
	}

	public RuneDmg(String rarity) {
		super(rarity);
		this.rarity = rarity;
		Random rand = new Random(); //instance of random class
		if(rarity == "white") {
			int upperbound = 3;
			int stats1Value = rand.nextInt(upperbound); 
			this.dmg = stats1Value + 1;
			this.name = "RDW";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgWhite.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "green") {
			int upperbound = 6;
			int stats1Value = rand.nextInt(upperbound); 
			this.dmg = stats1Value + 3;
			this.name = "RDG";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgGreen.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "blue") {
			int upperbound = 10;
			int stats1Value = rand.nextInt(upperbound); 
			this.dmg = stats1Value + 6;
			this.name = "RDB";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgBlue.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "purple") {
			int upperbound = 20;
			int stats1Value = rand.nextInt(upperbound); 
			this.dmg = stats1Value + 10;
			this.name = "RDP";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgPurple.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "orange") {
			int upperbound = 50;
			int stats1Value = rand.nextInt(upperbound); 
			this.dmg = stats1Value + 20;
			this.name = "RDO";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgOrange.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else {
			System.out.println("mauvai choix de raret�");
		}
	}
	
	public RuneDmg(String name, String rarity, int dmg) {
		super(name, rarity);
		this.name = name;
		this.rarity = rarity;
		this.dmg = dmg;
		
		if(rarity == "white") {
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgWhite.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "green") {
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgGreen.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "blue") {
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgBlue.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "purple") {
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgPurple.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "orange") {
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/runeDmgOrange.png"));
			} catch (IOException e) {e.printStackTrace();}
		}
	}
}
