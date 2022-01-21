package com.hakim.item;

import java.awt.Image;

public class Item {
	public String name;
	public String rarity;
	public int dmg;
	public Image img;
	
	public Item() {
		this.name = "";
		this.rarity = "";
	}
	Item(String rarity) {
		this.rarity = rarity;	
	}
	
	Item(String name, String rarity) {
		this.name = name;
		this.rarity = rarity;
	}
	
	
}
