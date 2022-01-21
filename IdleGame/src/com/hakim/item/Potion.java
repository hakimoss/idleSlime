package com.hakim.item;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Potion extends Item {
	String name;
	public Image img;
	String rarity;

	Potion() {
		this.name = "";
	}
	
	public Potion(String rarity) {
		super(rarity);
		
		if(rarity == "white") {
			this.name = "PW";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionWhite.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "green") {
			this.name = "PG";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionGreen.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "blue") {
			this.name = "PB";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionBlue.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if(rarity == "purple") {
			this.name = "PP";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionPurple.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else if (rarity == "orange") {
			this.name = "PO";
			try {
				this.img = ImageIO.read(getClass().getResource("/images/item/sPotionOrange.png"));
			} catch (IOException e) {e.printStackTrace();}
		} else {
			System.out.println("cette raret� n'existe pas");
		}
		
	}

	Potion(String name, String rarity) {
		super(name, rarity);
		
	}

}
