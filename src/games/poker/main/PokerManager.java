package games.poker.main;

public class PokerManager {
	Option option;

	public PokerManager(Option option) {
		this.option = option;

	}

	public void startGame() {
		Board board = new Board(option);
		execute.OpeningDraw(deck, player);
	}

}
