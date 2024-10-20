package games.poker.main;

public class PokerManager {
	Option option;
	Board board;
	Execute execute;

	public PokerManager(Option option) {
		this.option = option;
		this.execute = new Execute(option);

		board = new Board(option);
	}

	public void startGame() {
		board.deck.shuffle();
		execute.OpeningDraw(board);
		While(execute.allNotHold(board.players)&&execute.allNotHold(board.cpus));{
			for (int i = 0; i < board.player.length; i++) {
				execute.reroll(board.player[i]);
			}
			for (int i = 0; i < board.cpu.length; i++) {
				execute.reroll(board.cpu[i]);
			}
		}
		
		
		board.debug();
	}

}
