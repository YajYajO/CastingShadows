package CastingShadows;

import java.util.*;

public class Players extends Cards{
	Boolean alive;
	int numberOfActions, currentHexTile, currentHP, shadowCompanions;
	static int numPlayers = 0;
	ArrayList<Cards> spellBook = new ArrayList<Cards>();
	Income wallet = new Income();
	
	public Players() {
		this.alive = true;
		this.numberOfActions = 4;
		this.currentHP = 18;
		this.redGems = 0;
		this.redOrbs = 0;
		this.blueGems = 0;
		this.blueOrbs = 0;
		this.shadowFragments = 0;
		this.cursedCrystals = 0;
		this.spellBook.clear();
	}
	
	public void endTurn(Players player) {
		if(this.cursedCrystals > 0) {
			this.currentHP = this.currentHP - this.cursedCrystals;
		}
		this.redGems = 0;
		this.redOrbs = 0;
		this.blueGems = 0;
		this.blueOrbs = 0;
		this.cursedCrystals = 0;
	}
	
	public String getCurrentWallet(Players player) {
		String cost = "";
		cost = cost + "Blue Gems: " + player.wallet.getBlueGems() + "\n";
		cost = cost + "Red Gems: " + player.wallet.getRedGems() + "\n";
		cost = cost + "Blue Orbs: " + player.wallet.getBlueOrbs() + "\n";
		cost = cost + "Red Orbs: " + player.wallet.getRedOrbs() + "\n";
		cost = cost + "Shadow Fragments: " + player.wallet.getShadowFragments() + "\n";
		cost = cost + "Cursed Crystals: " + player.wallet.getCursedCrystals() + "\n";
		return cost;
	}
	
	public static void playerRoll(Players player) {
		for(int i = 0; i < playDice.size(); i++) {
			playDice.get(i).roll();
		}
		for(int i = 0; i < playDice.size(); i++) {
			if(playDice.get(i).getValue() == 1){
				player.addRedGems();
			}
			if(playDice.get(i).getValue() == 2){
				player.addBlueGems();
			}
			if(playDice.get(i).getValue() == 3){
				player.addRedOrbs();
			}
			if(playDice.get(i).getValue() == 4){
				player.addBlueOrbs();
			}
			if(playDice.get(i).getValue() == 5){
				player.addShadowFragments();
			}
			if(playDice.get(i).getValue() == 6){
				player.addCursedCrystals();
			}
		}
		
	}
	
	public static void playerReroll(Players player) {
		Scanner scan = new Scanner(System.in);
		String turn;
		System.out.println("Type the resources you would like to keep from your roll. Type \"Done\" when finshed");
		turn = scan.nextLine();
		System.out.println(toString(playDice));
		turn = scan.nextLine();
		while(!turn.equals("Done") && player.getNumberOfActions() > 0) {
			int index = 0, count = 0;
			if(turn.equals("Red Gems")) {
				for(int i = 0; i < playDice.size(); i++) {
					if(playDice.get(i).getValue() == 1) {
						index = i;
						count++;
						playDice.get(index).roll();
					}
				}
				if(count == 0) {
					System.out.println("You have no Red Gems to Reroll");
					player.addNumberOfActions();
				}
			
			}
			if(turn.equals("Blue Gems")) {
				for(int i = 0; i < playDice.size(); i++) {
					if(playDice.get(i).getValue() == 2) {
						index = i;
						count++;
						playDice.get(index).roll();
					}
				}
				if(count == 0) {
					System.out.println("You have no Blue Gems to Reroll");
					player.addNumberOfActions();
				}
			}
			if(turn.equals("Red Orbs")) {
				for(int i = 0; i < playDice.size(); i++) {
					if(playDice.get(i).getValue() == 3) {
						index = i;
						count++;
						playDice.get(index).roll();
					}
				}
				if(count == 0) {
					System.out.println("You have no Red Orbs to Reroll");
					player.addNumberOfActions();
				}
			}
			if(turn.equals("Blue Orbs")) {
				for(int i = 0; i < playDice.size(); i++) {
					if(playDice.get(i).getValue() == 4) {
						index = i;
						count++;
						playDice.get(index).roll();
					}
				}
				if(count == 0) {
					System.out.println("You have no Blue Orbs to Reroll");
					player.addNumberOfActions();
				}
			}
			if(turn.equals("Shadow Fragments")) {
				for(int i = 0; i < playDice.size(); i++) {
					if(playDice.get(i).getValue() == 5) {
						index = i;
						count++;
						playDice.get(index).roll();
					}
				}
				if(count == 0) {
					System.out.println("You have no Shadow Fragments to Reroll");
					player.addNumberOfActions();
				}
			}			
			if(turn.equals("Cursed Crystals")) {
                System.out.println("You can't reroll Cursed Crystals.");
                player.addNumberOfActions();
			}		
		player.reduceNumberOfActions();
		}
	}
	public void changeHP(int difference){
		this.currentHP = this.currentHP + difference;
	}
	
	public int getNumberOfActions() {
		return this.numberOfActions;
	}
	public void	reduceNumberOfActions() {
		this.numberOfActions--;
	}
	
	public void	addNumberOfActions() {
		this.numberOfActions++;
	}
		
	public void moveDown() {
		this.currentHexTile--;
	}
	
	public void moveUp() {
		this.currentHexTile++;
	}
	
	public int getHP() {
		return this.currentHP;
	}
	
	public int getLocation() {
		return this.currentHexTile;
	}
}
	
	