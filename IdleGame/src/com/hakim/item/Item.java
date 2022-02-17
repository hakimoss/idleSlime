package com.hakim.item;

import java.awt.Image;

public class Item {
	public String name;
	public String rarity;
	public int tier;
	public int dmg;
	public Image img;
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
