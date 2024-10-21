package games.poker.main;

import java.util.ArrayList;

public class MathScore {

	public void scoreClearing(Player player, Card[] hands) {
		int[] suitMatch = getSuitMatch(player.hands);
		int[] numMatch = getNumMatch(player.hands);
		if (getRoyalCount(player) == 5 && getMaxSuit(suitMatch) == 5) {
			player.comboScore = 900;
		} else if (getStraightCount(player) == 4 && getMaxSuit(suitMatch) == 5) {
			player.comboScore = 800;
		} else if (getMatchCombo(numMatch) == 700) {
			player.comboScore = 700;
		} else if (getMatchCombo(numMatch) == 600) {
			player.comboScore = 600;
		} else if (getMaxSuit(suitMatch) == 4) {
			player.comboScore = 550;
		} else if (getRoyalCount(player) == 5) {
			player.comboScore = 510;
		} else if (getStraightCount(player) == 4) {
			player.comboScore = 500;
		} else {
			player.comboScore = getMatchCombo(numMatch);// 450,300,150
		}
	}

	public int getRoyalCount(Player player) {
		int royalCount = 0;
		int need[] = { 10, 11, 12, 13, 1 };

		for (int i = 0; i < need.length; i++) {
			for (int j = 0; j < player.hands.length; j++) {
				if (need[i] == player.hands[j].num) {
					royalCount++;
					player.usedIndexs[i] = j;
					break;
				}
			}
		}
		return royalCount;
	}

	public int[] getSuitMatch(Card[] hands) {
		int[] suitMatch = new int[hands.length];
		for (int i = 1; i < hands.length; i++) {
			for (int j = 0; j < hands.length; j++) {
				if (hands[i].suit == hands[i + 1].suit) {
					suitMatch[i]++;
				}
			}
		}
		return suitMatch;
	}

	public int[] getNumMatch(Card[] hands) {
		int[] numMatch = new int[hands.length];
		for (int i = 0; i < hands.length; i++) {
			for (int j = 0; j < hands.length; j++) {
				if (hands[i].num == hands[j].num) {
					numMatch[i]++;
				}
			}
		}
		return numMatch;
	}

	public int getMaxSuit(int[] suitMatch) {
		int max = 0;
		for (int i = 0; i < suitMatch.length; i++) {
			if (max < suitMatch[i]) {
				max = suitMatch[i];
			}
		}
		return max;
	}

	public int getStraightCount(Player player) {
		int straightCount = 0;
		int max = 0;
		for (int i = 0; i < player.hands.length - 4; i++) {
			straightCount = 0;
			for (int index : player.usedIndexs) {
				player.usedIndexs[index] = 0;
			}
			for (int j = i + 1; j < player.hands.length - i; j++) {
				if (player.hands[j - 1].num == player.hands[j].num + 1) {
					player.usedIndexs[straightCount] = j;
					straightCount++;
					if (straightCount == 4) {
						player.usedIndexs[straightCount] = i;
						player.numScore = i;
						return straightCount;
					}
					if (max < straightCount) {
						max = straightCount;
					}

				} else if (player.hands[j - 1].num > player.hands[j].num + j) {
					break;
				} else {
					continue;
				}
			}
		}
		return max;
	}

	public static int getMatchCombo(int[] match) {
		int matchCombo = 0;
		for (int i = 0; i < match.length; i++) {
			switch (match[i]) {
			case 4:
				matchCombo += 175;
				break;
			case 3:
				matchCombo += 150;
				break;
			case 2:
				matchCombo += 75;
				break;
			case 1:
				matchCombo += 0;
				break;
			}
		}
		return matchCombo;
	}

//	public Player getWinner(Player[] allPlayers) {
//		ArrayList<Player> winner = new ArrayList<Player>();
//		for(Player player : allPlayers) {
//			winner.add(player);
//		}
//		while(winner.size() != 1) {
//			winner = getComboWinner(winner);
//			winner = getNumWinner(winner);
//		}
//		
//			
//	}

	public ArrayList<Player> getComboWinner(ArrayList<Player> winners) {
		ArrayList<Player> winner = new ArrayList<>();
		int maxScore = 0;
		for (int i = 0; i < winners.size(); i++) {
			if (maxScore < winners.get(i).comboScore) {
				maxScore = winners.get(i).comboScore; // 最大スコア保存
				winner.clear(); // 最大スコアが更新されたら旧同点1位はリセット
				winner.add(winners.get(i)); // 最大スコア更新で、1位のプレイヤーも更新
			} else if (maxScore == winners.get(i).comboScore) { // 最大スコアと同点だったら
				winner.add(winners.get(i)); // 同点1位のプレイヤーとして保存
			}
		}
		return winner;
	}

	public ArrayList<Player> getNumWinner(ArrayList<Player> winners) {
		ArrayList<Player> winner = new ArrayList<>();
		int maxScore = 0;
		for (int i = 0; i < winners.size(); i++) {
			if (maxScore < winners.get(i).numScore) {
				maxScore = winners.get(i).numScore; // 最大スコア保存
				winner.clear(); // 最大スコアが更新されたら旧同点1位はリセット
				winner.add(winners.get(i)); // 最大スコア更新で、1位のプレイヤーも更新
			} else if (maxScore == winners.get(i).numScore) { // 最大スコアと同点だったら
				winner.add(winners.get(i)); // 同点1位のプレイヤーとして保存
			}
		}
		return winner;
	}

}