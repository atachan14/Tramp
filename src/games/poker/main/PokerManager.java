package games.poker.main;

import java.util.ArrayList;

public class PokerManager {
	Option option;
	Board board;
	Execute execute;
	UI ui;

	public PokerManager(Option option) {
		this.option = option;
		board = new Board(option);
		execute = new Execute(option);
		ui = new UI();
	}

	public void startGame() {
		ui.start(board);
		board.deck.shuffle();
		execute.OpeningDraw(board);
		while (execute.allHold(board.allPlayers) == false) {
			for (int i = 0; i < board.allPlayers.length; i++) {
				if (board.allPlayers[i].hold) {
					continue;
				}
				ui.turnOpening(board.allPlayers[i]);
				ui.handsDisplay(board.allPlayers[i]);
				board.allPlayers[i].rerollinput(board.allPlayers[i]);
				if (board.allPlayers[i].input == 0) {
					board.allPlayers[i].hold = true;
					System.out.println();
					continue;
				}
				ArrayList<Integer> indexs = execute.getIndexFromDigit(board.allPlayers[i].input);
				board.allPlayers[i].turnReroll(board, indexs);
				ui.afterDisplay(board.allPlayers[i], indexs);
				System.out.println();
			}

		}
		scoreClearing();
//		winnerJudge();
//		result();
//		retrySelect();
		
//		board.debug();
	}

}
