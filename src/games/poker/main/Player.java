package games.poker.main;

import java.util.ArrayList;

public class Player {
	String name;
	int reroll;
	boolean hold = false;
	Card[] hands;
	Option option;
	UI ui = new UI();

	public Player(Option option,int index) {
		this.option = option;
		this.name = "player"+(index+1);
		this.hands = new Card[option.getMaxHands()];
		this.reroll = option.getMaxReroll();
		
	}

	public Card[] getHands() {
		return hands;
	}
	
	public String getName() {
		return name;
	}

	public void drawCard(Deck deck, int index) {
		hands[index] = deck.drawCard();
	}

	public void rerollCard(Board board,int index) {
		Card gift = hands[index];
		drawCard(board.deck,index);
		board.grave.addGrave(gift);
	}
	
	public void openingDraw(Deck deck) {
		for (int i = 0; i < hands.length; i++) {
			drawCard(deck, i);
		}
	}
	
	public void turnReroll(Board board, ArrayList<Integer> indexs) {
		for (int index : indexs)
			rerollCard(board, index);
		reroll--;
	}
	
	
	public int rerollinput(Player player) {
		System.out.print("　1~5.reroll(複数選択可) 0.hold ＞" );
		int input = new java.util.Scanner(System.in).nextInt();
		return input;
	}
	
	
}
