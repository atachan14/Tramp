package games.poker.main;

import java.util.ArrayList;

public class Player {
	String name;
	int reroll;
	boolean hold = false;
	ArrayList<Card> hands;
	Option option;
	UI ui = new UI();
	int input;
	int comboScore;
	int numScore;
	ArrayList<Card> usedHands;
	

	public Player(Option option, int index) {
		this.option = option;
		this.name = "player" + (index + 1);
		this.reroll = option.getMaxReroll();
		this.hands = new ArrayList<Card>();
		usedHands = new ArrayList<Card>();
		ArrayList<Integer> numMatch = new ArrayList<Integer>();
		ArrayList<Integer> suitMatch = new ArrayList<Integer>();
		
	}

	public ArrayList<Card> getHands() {
		return hands;
	}

	public String getName() {
		return name;
	}

	public void drawCard(Deck deck, int index) {
		hands.add(deck.drawCard());
	}

	public void rerollCard(Board board, int index) {
		board.grave.addGrave(hands.get(index));
		hands.set(index, board.deck.drawCard());
	}

	public void toUsedHands(int index) {
		usedHands.add(hands.remove(index));
		
	}

	public void openingDraw(Deck deck) {
		for (int i = 0; i < option.getMaxHands(); i++) {
			drawCard(deck, i);
		}
	}

	public void turnReroll(Board board, ArrayList<Integer> indexs) {
		for (int index : indexs)
			rerollCard(board, index);
		reroll--;
		if (reroll == 0)
			hold = true;
	}

	public void rerollinput(Player player) {
		System.out.print("　1~5.reroll(複数選択可) 0.hold ＞");
		input = new java.util.Scanner(System.in).nextInt();
	}

}
