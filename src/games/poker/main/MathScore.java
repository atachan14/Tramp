package games.poker.main;

import java.util.ArrayList;

public class MathScore {

	public void scoreClearing(Player player, ArrayList<Card> hands) {
		int[] suitMatch = getSuitMatch(player.hands);
		int[] numMatch = getNumMatch(player.hands);
		System.out.println("match go");

		
		
		if (getRoyalCount(player) == 5 && getMaxSuit(suitMatch) == 5) {
			player.comboScore = 900;
			System.out.println("royal go");
		} else if (getStraightCount(player) == 4 && getMaxSuit(suitMatch) == 5) {
			player.comboScore = 800;
			System.out.println("sutohra go");
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
			for (int j = 0; j < player.hands.size(); j++) {
				if (need[i] == player.hands.get(j).num) {
					royalCount++;
//					player.usedHands.set(i, player.hands.get(j));
					break;
				}
			}
		}
		return royalCount;
	}

	public int[] getSuitMatch(ArrayList<Card> hands) {
		int[] suitMatch = new int[hands.size()];
		for (int i = 0; i < hands.size(); i++) {
			for (int j = 0; j < hands.size(); j++) {
				if (hands.get(i).suit == hands.get(j).suit) {
					suitMatch[i]++;
				}
			}
		}
		return suitMatch;
	}

	public int[] getNumMatch(ArrayList<Card> hands) {
		int[] numMatch = new int[hands.size()];
		for (int i = 0; i < hands.size(); i++) {
			for (int j = 0; j < hands.size(); j++) {
				if (hands.get(i).num == hands.get(j).num) {
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
		for (int i = 0; i < player.hands.size() - 4; i++) {
			straightCount = 0;
			for (Card card : player.usedHands) {
				player.hands.add(card);
			}
			player.usedHands.clear();

			for (int j = i + 1; j < player.hands.size() - i; j++) {
				if (player.hands.get(j - 1).num == player.hands.get(j).num + 1) {
					player.usedHands.add(player.hands.get(j - 1));
					straightCount++;
					if (straightCount == 4) {
						player.usedHands.add(player.hands.get(j));
						player.numScore = i;
						return straightCount;
					}
					if (max < straightCount) {
						max = straightCount;
					}

				} else if (player.hands.get(j - 1).num > player.hands.get(j).num + 1) {
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

	public void mathComboWinner(ArrayList<Player> winners) {
		int maxComboScore = 0;
		ArrayList<Player> newWinners = new ArrayList<Player>();
		for (int i = 0; i < winners.size(); i++) {
			if (maxComboScore < winners.get(i).comboScore) {
				maxComboScore = winners.get(i).comboScore; // 最大スコア保存
				newWinners.clear(); // 最大スコアが更新されたら旧同点1位はリセット
				newWinners.add(winners.get(i)); // 最大スコア更新で、1位のプレイヤーも更新
			} else if (maxComboScore == winners.get(i).comboScore) { // 最大スコアと同点だったら
				newWinners.add(winners.get(i)); // 同点1位のプレイヤーとして保存
			}
		}
		winners.clear();
		for (Player newWinner : newWinners) {
			winners.add(newWinner);
		}
	}

	public void mathNumWinner(ArrayList<Player> winners) {
		int maxNumScore = 0;
		ArrayList<Player> newWinners = new ArrayList<Player>();
		for (int i = 0; i < winners.size(); i++) {
			if (maxNumScore < winners.get(i).numScore) {
				maxNumScore = winners.get(i).numScore; // 最大スコア保存
				newWinners.clear(); // 最大スコアが更新されたら旧同点1位はリセット
				newWinners.add(winners.get(i)); // 最大スコア更新で、1位のプレイヤーも更新
			} else if (maxNumScore == winners.get(i).numScore) { // 最大スコアと同点だったら
				newWinners.add(winners.get(i)); // 同点1位のプレイヤーとして保存
			}
		}
		winners.clear();
		for (Player newWinner : newWinners) {
			winners.add(newWinner);
		}
	}
}