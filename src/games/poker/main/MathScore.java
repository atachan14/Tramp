package games.poker.main;

public class MathScore {

	public void scoreClearing(Player player, Card[] hands) {
		if (getRoyalCount(hands) == 5 && getflashCount(getSuitMatch(hands)) == 5) {
			player.comboScore = 900;
		} else if (straightJudge(player, hands)[0] == 4 && getflashCount(getSuitMatch(hands)) == 5) {
			player.comboScore = 800;
		} else if (matchComboJudge(player, matchCount(player, hands))[0] == 700) {
			player.comboScore = 700;
		} else if (matchComboJudge(player, matchCount(player, hands))[0] == 600) {
			player.comboScore = 600;
		} else if (flashJudge(player, hands)[0] == 4) {
			player.comboScore = 550;
		} else if (straightJudge(player, hands)[0] == 4) {
			player.comboScore = 500;
		} else {
			player.comboScore = matchComboJudge(player, matchCount(player, hands))[0];// 450,300,150
		}
	}

	public int getRoyalCount(Card[] hands) {
		int royalCount = 0;
		int need[] = { 10, 11, 12, 13, 1 };

		for (int i = 0; i < need.length; i++) {
			for (int j = 0; j < hands.length; j++) {
				if (need[i] == hands[j].num) {
					royalCount++;
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

	public int getflashCount(int[] suitMatch) {
		int max = 0;
		for (int i = 0; i < suitMatch.length; i++) {
			if (max < suitMatch[i]) {
				max = suitMatch[i];
			}
		}
		return max;
	}

	public int getStraightCount(Card[] hands) {
		int straightCount = 0;
		for (int i = 0; i < hands.length - 4; i++) {
			straightCount = 0;
//			System.out.println("i=" + i);
			for (int j = i + 1; j < hands.length; j++) {
//				System.out.println("j=" + j);
				if (hands[j - 1].num == hands[j].num + 1) {
					straightCount++;
					
//					System.out.println("str=" + straight[0]);
					if (straightCount == 4) {
//						System.out.println("straight==4");
						straightCount = j;
						return straightCount;
					}
//					System.out.println("continue前");
					continue;
				}
				if (hands[j - 1].num > (hands[j]).num + 1)
//					System.out.println("break前");
					break;
			}
		}
//		System.out.println("0=0前");
		return straightCount;
	}
	
	public void 
}