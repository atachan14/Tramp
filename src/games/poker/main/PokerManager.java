package games.poker.main;

public class PokerManager {
	Option option;
	Board board;
	Execute execute;
	
	public PokerManager(Option option) {
		this.option = option;
		board = new Board(option);
		this.execute = new Execute(option);
	}

	public void startGame() {

		board.deck.shuffle();
		execute.OpeningDraw(board.deck, board.player);
		board.debug();

	}

}
