package games.poker.main;

public class Player {
	
	int reroll;
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
}
