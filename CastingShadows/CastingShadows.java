package CastingShadows;

import java.util.*;

public class CastingShadows extends Players{
	static ArrayList<Players> players = new ArrayList<Players>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many players are playing?");
		numPlayers = scan.nextInt();
		while(numPlayers < 1 || numPlayers > 4) {
			System.out.println("How many players are playing?");
			numPlayers = scan.nextInt();
			}
		
		for(int i = 0; i < numPlayers; i++) {
			players.add(new Players());
		}
			/*
			for(int i = 0; i < playDice.size(); i++) {
				playDice.get(i).roll();
			}
			*/
		for(int i = 0; i < 5; i++) {
			playDice.add(new Dice());
		}
		for(int i = 0; i < playDice.size(); i++) {
			playDice.get(i).roll();
		}
		playerRoll(players.get(0));
		System.out.println(currentGameStatus());
		startTurn(playDice, players.get(0));
	}
	
	public static void startTurn(ArrayList<Dice> dice, Players player) {
		Scanner scan = new Scanner(System.in);
		rerollDice(dice);
		System.out.println(toString(dice));
		String turn;
		System.out.println("Travel, Cast, Reroll, Protect, Purchase");
		turn = scan.nextLine();
		//turn.equals("Travel") || turn.equals("Cast") || turn.equals("Reroll") || turn.equals("Protect") || turn.equals("Purchase")
		while(player.getNumberOfActions() > 0){
			if(turn.equals("Reroll")) {
				playerReroll(player);
			}
		}
	}
	
	
	public static String currentGameStatus() {
		String status = "";
		for(int i = 1; i <= players.size(); i++) {
			status = status + "Player " + i + ":" +
					"\nHealth: " + players.get(i-1).getHP() + 
					"\nLocation: " + players.get(i-1).getLocation() + 
					"\nNumber of Shadow Fragments: " + players.get(i-1).getShadowFragments() + "\n\n";
		}
		return status;
	}
	
	

}

