package games.poker.main;

import java.util.ArrayList;

public class Execute {
	Option option;

	public Execute(Option option) {
		this.option = option;
	}

	public void OpeningDraw(Board board) {
		for (int i = 0; i < board.allPlayers.length; i++) {
			for (int j = 0; j < board.allPlayers[i].hands.length; j++)
				board.allPlayers[i].drawCard(board.deck, j);
		}
	}

	public boolean allHold(Player[] allPlayers) {
		for (Player player : allPlayers) {
			if (!player.hold) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer> getIndexFromDigit(int input) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		while (input > 0) {
			indexs.add(input % 10 - 1);
			input /= 10;
		}
		return indexs;
	}
}