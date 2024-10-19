package games.poker.main;
import java.util.ArrayList;

public class Player {
	ArrayList<Card> hands;
	int reroll;
	Option option;
	
	public Player(Option option) {
		this.option = option;
		hands = new ArrayList<Card>();
		reroll = option.getMaxReroll();
	}
}
