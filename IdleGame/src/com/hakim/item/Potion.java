package com.hakim.item;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Potion extends Item {
	public String name;
	public Image img;
	String rarity;
	public int value;
	
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

	Potion() {
		this.name = "";
	}
	
	public Potion(String rarity) {
		super(rarity);
		this.stats1 = "N";
		this.stats1Value = 00;
		this.stats2 = "N";
		this.stats2Value = 00;
		this.stats3 = "N";
		this.stats3Value = 00;
		this.stats4 = "N";
		this.stats4Value = 00;
		this.stats5 = "N";
		this.stats5Value = 00;
		if(rarity == "white") {
			this.name = "PW";
			this.value = 5;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionWhite.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "green") {
			this.name = "PG";
			this.value = 10;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionGreen.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "blue") {
			this.name = "PB";
			this.value = 20;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionBlue.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "purple") {
			this.name = "PP";
			this.value = 30;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionPurple.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if (rarity == "orange") {
			this.name = "PO";
			this.value = 50;
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionOrange.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else {
			System.out.println("cette raret? n'existe pas");
		}
		
	}

	Potion(String name, String rarity) {
		super(name, rarity);
		
	}

}
