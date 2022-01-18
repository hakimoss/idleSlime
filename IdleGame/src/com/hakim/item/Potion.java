package com.hakim.item;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Potion extends Item {
	String name;
	public Image img;
	
	Potion() {
		this.name = "";
	}
	
	public Potion(String rarity) {
		super(rarity);
		this.name = "P";
		try {
			this.img = ImageIO.read(getClass().getResource("/images/item/potionIcon.png"));
		} catch (IOException e) {e.printStackTrace();}
	}

	Potion(String name, String rarity) {
		super(name, rarity);
		
	}

}
