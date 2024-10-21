package games.poker.main;

import java.util.ArrayList;

public class PokerManager {
	Option option;
	Board board;
	Execute execute;
	UI ui;
	MathScore mathScore;

	public PokerManager(Option option) {
		this.option = option;
		board = new Board(option);
		execute = new Execute();
		ui = new UI();
		mathScore=new MathScore();
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
		for (Player player : board.allPlayers) {
			execute.sort(player.hands);
			mathScore.scoreClearing(player,player.hands);
		}
		mathScore.winnerJudge();
		do {
			mathScore.getComboWinner(board.allPlayers);
		}while()
//		winnerJudge();
//		result();
//		retrySelect();

//		board.debug();
	}

}
