package games.poker.main;

import java.util.ArrayList;

public class Execute {


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

	public void sort(Card[] hands) {
		for (int i = 0; i < hands.length - 1; i++) {
			for (int j = i + 1; j < hands.length; j++) {
				if (hands[i].num < hands[j].num) {
					Card temp = hands[i];
					hands[i] = hands[j];
					hands[j] = temp;
				}
			}
		}
	}

}