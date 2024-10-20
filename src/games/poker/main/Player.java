package games.poker.main;

public class Player {
	int reroll;
	boolean notHold=true;
	Card[] hands;
	Option option;
	
	
	public Player(Option option) {
		this.option = option;
		this.hands = new Card[option.getMaxHands()];
		reroll = option.getMaxReroll();		
	}

	public Card[] getHands() {
		return hands;
	}

	public void addCard(Deck deck, int index) {
		hands[index] = deck.drawCard();
	}
	
	public void openingDraw(Deck deck) {
		for (int i = 0; i < hands.length; i++) {
			addCard(deck,i);
		}
	}
}
