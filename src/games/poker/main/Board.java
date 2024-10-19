package games.poker.main;

public class Board {
	Option option;
	Deck deck;
	Player[] player;
	Execute execute = new Execute(option);

	public Board(Option option) {
		this.option = option;
		deck = new Deck();
		player = new Player[option.getMaxPlayer()];
		for (int i = 0; i < player.length; i++) {
			player[i] = new Player(option);
		}
	}

	public void debug() {
		for (int i = 0; i < option.getMaxPlayer(); i++) {
			for (int j = 0; j < option.getMaxHands(); j++) {
				System.out.print(player[i].hands[j]+" ");
			}
			System.out.println();
		}
	}
}
