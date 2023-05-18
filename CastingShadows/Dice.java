package CastingShadows;

import java.util.*;

public class Dice{
	int value;
	private static Boolean shouldRoll;
	static ArrayList<Dice> playDice = new ArrayList<Dice>();
	
	public static void main(String args[]) {
		for(int i = 0; i < 5; i++) {
			playDice.add(new Dice());
		}
		for(int i = 0; i < playDice.size(); i++) {
			playDice.get(i).roll();
		}
	}
	
	public Dice() {
		this.value = 0;
		this.shouldRoll = true;
	}
	
	public int getValue() {
		return value;
	}
	
	public static boolean getShouldRoll() {
		return shouldRoll;
	}
	
	public void setShouldRoll(boolean should) {
		this.shouldRoll = should;
	}
	
	
	public void roll() {
		Random rand = new Random();
		this.value = rand.nextInt(6) + 1;
	}
	
	
	public static void rerollDice(ArrayList<Dice> Dice) {
		for(int i = 0; i < Dice.size(); i++) {
			if(Dice.get(i).getShouldRoll()){
				Dice.get(i).roll();
			}
		}
	}
	
	/*
	 * Dice Rolls Meanings:
	 * 1 = redGems
	 * 2 = blueGems
	 * 3 = redOrbs
	 * 4 = blueOrbs
	 * 5 = shadowFragments
	 * 6 = cursedCrystals
	 * 
	 * Red Gems: Blue Gems: Red Orbs: Blue Orbs: Shadow Fragments: Cursed Crystals:
	 */ 
	
	public static String toString(ArrayList<Dice> Dice) {
		int redGems = 0, blueGems = 0, redOrbs = 0, blueOrbs = 0, shadowFragments = 0, cursedCrystals = 0;
		String output = "Your Dice Rolled: \n";
		//output = output + Dice.get(i).getValue()  + " ";
		for(int i = 0; i < Dice.size(); i++) {
			if(Dice.get(i).getValue() == 1) {
				redGems++;
			}
			if(Dice.get(i).getValue() == 2) {
				blueGems++;
			}
			if(Dice.get(i).getValue() == 3) {
				redOrbs++;
			}
			if(Dice.get(i).getValue() == 4) {
				blueOrbs++;
			}
			if(Dice.get(i).getValue() == 5) {
				shadowFragments++;
			}
			if(Dice.get(i).getValue() == 6) {
				cursedCrystals++;
				Dice.get(i).shouldRoll = false;
			}
		}
		output = output + "Red Gems: " + redGems + "\n";
		output = output + "Blue Gems: " + blueGems + "\n";
		output = output + "Red Orbs: " + redOrbs + "\n";
		output = output + "Blue Orbs: " + blueOrbs + "\n";
		output = output + "Shadow Fragments: " + shadowFragments + "\n";
		output = output + "Cursed Crystals: " + cursedCrystals + "\n";
		return output;
	}

}

