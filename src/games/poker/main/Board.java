package games.poker.main;

public class Board {
	Option option;
	Deck deck;
	Player[] player;
	Execute execute = new Execute();

	public Board(Option option) {
		this.option = option;
		deck = new Deck();
		player = new Player[option.getMaxPlayer()];
		
	}
}
