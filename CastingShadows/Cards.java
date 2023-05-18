package CastingShadows;

import java.util.*;

public class Cards extends Income{
	String cardName;
	int range, damage, level;
	Income buyCost = new Income();
	Income useCost = new Income();
	
	public static void main(String args[]) {
		LinkedList<Cards> gameDeck = new LinkedList<Cards>();
		
		//Making the main deck;
		for(int i = 0; i < 3; i++) {
			gameDeck.push(new Cards("The Bees",1, 1, 2));
		}
		for(int i = 0; i < gameDeck.size(); i++) {
			if(gameDeck.get(i).cardName.equals("The Bees")) {
				gameDeck.get(i).setBuyCost(1, 0, 1, 0, 0, 0);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			gameDeck.push(new Cards("Magical Slap", 1, 2, 1));
		}
		
		
		for(int i = 0; i < gameDeck.size(); i++) {
			if(gameDeck.get(i).cardName.equals("Magical Slap")) {
				gameDeck.get(i).setBuyCost(0, 1, 0, 1, 0, 0);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			gameDeck.push(new Cards("Penalizing Pinch", 1 , 1, 1));
		}
		
		for(int i = 0; i < gameDeck.size(); i++) {
			if(gameDeck.get(i).cardName.equals("Penalizing Pinch")) {
				gameDeck.get(i).setBuyCost(1, 0, 0, 1, 0, 0);
			}
		}
		
		shuffleDeck(gameDeck);
		
		for(int i = 0; i < gameDeck.size(); i++) {
			System.out.println(gameDeck.get(i).cardPurchaseInfo(gameDeck.get(i)));
		}

		
		
	}
		
	public Cards(String cardName,int level, int range, int damage) {
		this.cardName = cardName;
		this.level = level;
		this.range = range;
		this.damage = damage;	
	}
	
	public Cards() {
		this.cardName = "No Name";
		this.level = 0;
		this.range = 0;
		this.damage = 0;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public String getCardName() {
		return this.cardName;
	}
	
	public void setBuyCost(int blueGems, int redGems, int blueOrbs, int redOrbs, int shadowFragments, int cursedCrystals) {
		this.buyCost.blueGems = blueGems;
		this.buyCost.redGems = redGems;
		this.buyCost.blueOrbs = blueOrbs;
		this.buyCost.redOrbs = redOrbs;
		this.buyCost.shadowFragments = shadowFragments;
		this.buyCost.cursedCrystals = cursedCrystals;
	}
	public String cardPurchaseInfo(Cards card) {
		String difference = "You need the following for \"" + card.getCardName() + "\"\n";
		if(card.getBuyCost().getBlueGems() > 0) {
			difference = difference + "Blue Gems: " + card.getBuyCost().getBlueGems() + "\n";
		}
		if(card.getBuyCost().getRedGems() > 0) {
			difference = difference + "Red Gems: " + card.getBuyCost().getRedGems() + "\n";
		}
		if(card.getBuyCost().getBlueOrbs() > 0) {
			difference = difference + "Blue Orbs: " + card.getBuyCost().getBlueOrbs() + "\n";
		}
		if(card.getBuyCost().getRedOrbs() > 0) {
			difference = difference + "Red Orbs: " + card.getBuyCost().getRedOrbs() + "\n";
		}
		if(card.getBuyCost().getShadowFragments() > 0) {
			difference = difference + "Shadow Fragments: " + card.getBuyCost().getShadowFragments() + "\n";
		}
		if(card.getBuyCost().getCursedCrystals() > 0) {
			difference = difference + "Cursed Crystals: " + card.getBuyCost().getCursedCrystals() + "\n";
		}
		
		difference = difference + "\n";
		difference = difference + card.getCardName()+ ": \n";
		if(card.useCost.getBlueGems() > 0) {
			difference = difference + "Blue Gems: " + card.getBuyCost().getBlueGems() + "\n";
		}
		if(card.useCost.getRedGems() > 0) {
			difference = difference + "Red Gems: " + card.getBuyCost().getRedGems() + "\n";
		}
		if(card.useCost.getBlueOrbs() > 0) {
			difference = difference + "Blue Orbs: " + card.getBuyCost().getBlueOrbs() + "\n";
		}
		if(card.useCost.getRedOrbs() > 0) {
			difference = difference + "Red Orbs: " + card.getBuyCost().getRedOrbs() + "\n";
		}
		if(card.useCost.getShadowFragments() > 0) {
			difference = difference + "Shadow Fragments: " + card.getBuyCost().getShadowFragments() + "\n";
		}
		if(card.useCost.getCursedCrystals() > 0) {
			difference = difference + "Cursed Crystals: " + card.getBuyCost().getCursedCrystals() + "\n";
		}
		
		difference = difference + "Attack Power: " + card.getDamage() + "\n";
		difference = difference + "Range: " + card.getRange() + "\n\n";
		return difference;
	}
	
	public void differenceOfIncomes(Cards card, Income wallet) {
		if((card.getBuyCost().getBlueGems() > 0) && (wallet.getBlueGems() >= card.getBuyCost().getBlueGems())) {
			for(int i = 0; i < card.getBuyCost().getBlueGems(); i++) {
				wallet.takeBlueGems();
			}
		}
		if((card.getBuyCost().getRedGems() > 0) && (wallet.getRedGems() >= card.getBuyCost().getRedGems())) {
			for(int i = 0; i < card.getBuyCost().getRedGems(); i++) {
				wallet.takeRedGems();
			}
		}
		if((card.getBuyCost().getBlueOrbs() > 0) && (wallet.getBlueOrbs() >= card.getBuyCost().getBlueOrbs())) {
			for(int i = 0; i < card.getBuyCost().getBlueOrbs(); i++) {
				wallet.takeBlueOrbs();
			}
		}
		if((card.getBuyCost().getRedOrbs() > 0) && (wallet.getRedOrbs() >= card.getBuyCost().getRedOrbs())) {
			for(int i = 0; i < card.getBuyCost().getRedOrbs(); i++) {
				wallet.takeRedOrbs();
			}
		}
		if((card.getBuyCost().getShadowFragments() > 0) && (wallet.getShadowFragments() >= card.getBuyCost().getShadowFragments())) {
			for(int i = 0; i < card.getBuyCost().getShadowFragments(); i++) {
				wallet.takeShadowFragments();
			}
		}
		if((card.getBuyCost().getCursedCrystals() > 0) && (wallet.getCursedCrystals() >= card.getBuyCost().getCursedCrystals())) {
			for(int i = 0; i < card.getBuyCost().getCursedCrystals(); i++) {
				wallet.takeCursedCrystals();
			}
		}
	}
	
	public void addToSpellbook(Cards card, Players player) {
		differenceOfIncomes(card, player.wallet);
		player.spellBook.add(card);
	}
	
	public void swapCards(Cards card1, Cards card2) {
		Cards swapCard = new Cards();
		swapCard = card1;
		card1 = card2;
		card2 = swapCard;
	}
	
	static void shuffleDeck(LinkedList<Cards> gameDeck){
        Random rand = new Random();
        
        for(int i = 0; i < gameDeck.size() - 1; i++) {
            int index = rand.nextInt(i + 1);
            //swap gameDeck[i] with gameDeck[index]
            Collections.swap(gameDeck, i, index); 
        }
    }

	public Income getBuyCost() {
		return buyCost;
	}


}

