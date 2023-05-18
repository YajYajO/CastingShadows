package CastingShadows;

import java.util.*;

public class Income extends Dice{
	int redGems, blueGems, redOrbs, blueOrbs, shadowFragments, cursedCrystals;
	/*
	 * Dice Rolls Meanings:
	 * 1 = redGems
	 * 2 = blueGems
	 * 3 = redOrbs
	 * 4 = blueOrbs
	 * 5 = shadowFragments
	 * 6 = cursedCrystals
	 */
	public Income() {
		this.redGems = 0;
		this.blueGems = 0;
		this.redOrbs = 0;
		this.blueOrbs = 0;
		this.shadowFragments = 0;
		this.cursedCrystals = 0;
	}
	public void addRedGems() {
		this.redGems++;
	}
	
	public void takeRedGems() {
		this.redGems--;
	}
	
	public void addBlueGems() {
		this.blueGems++;
	}
	
	public void takeBlueGems() {
		this.blueGems--;
	}
	
	public void addRedOrbs() {
		this.redOrbs++;
	}
	
	public void takeRedOrbs() {
		this.redOrbs--;
	}
	
	public void addBlueOrbs() {
		this.blueOrbs++;
	}
	
	public void takeBlueOrbs() {
		this.blueOrbs--;
	}
	
	public void addCursedCrystals() {
		this.cursedCrystals++;
	}
	
	public void takeCursedCrystals() {
		this.cursedCrystals--;
	}
	
	public void addShadowFragments() {
		this.shadowFragments++;
	}
	
	public void takeShadowFragments() {
		this.shadowFragments--;
	}
	
	public int getShadowFragments() {
		return this.shadowFragments;
	}
	
	public int getRedGems() {
		return this.redGems;
	}
	
	public int getBlueGems() {
		return this.blueGems;
	}
	
	public int getRedOrbs() {
		return this.redOrbs;
	}
	
	public int getBlueOrbs() {
		return this.blueOrbs;
	}
	
	public int getCursedCrystals() {
		return this.cursedCrystals;
	}
	

	
	
	

}
