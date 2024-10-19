package games.poker.main;

public class Execute {
	Option option;

	public Execute(Option option) {
		this.option = option;
	}

	public void OpeningDraw(Deck deck, Player[] player) {
		System.out.println(option.getMaxHands());
		System.out.println(option.getMaxPlayer());
		for (int i = 0; i < option.getMaxHands(); i++) {
			for (int j = 0; j < option.getMaxPlayer(); j++) {
				Card temp = deck.drawCard();
				player[j].hands[i] = temp;
			}
		}
	}
	
	
}
