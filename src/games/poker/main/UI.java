package games.poker.main;

import java.util.ArrayList;

public class UI {
	Option option;
	//	Board board;
	//	public UI(Option option,Board board){
	//		this.option = option;
	//		this.board = board;
	//	}

	public void start(Board board) {
		System.out.println("Pokerを開始します。");
		System.out.print("参加者は");
		for (int i = 0; i < board.players.length; i++) {
			System.out.print(board.players[i].getName() + ",");
		}
		for (int i = 0; i < board.cpus.length; i++) {
			System.out.print(board.cpus[i].getName() + ",");
		}
		System.out.println("の" + board.allPlayers.length + "名です。");
		System.out.println();
	}

	public void turnOpening(Player player) {
		System.out.println(player.name + "のターンです。 リロール可能数は残り" + player.reroll + "回です。");
	}

	public void handsDisplay(Player player) {
		System.out.print(" ");
		for (Card all : player.hands)
			System.out.print("［" + all + "］");
	}

	public void afterDisplay(Player player, ArrayList<Integer> indexs) {
		System.out.print("→");
		for (int i = 0; i < player.hands.size(); i++) {
			if (indexs.contains(i)) {
				System.out.print("【" + player.hands.get(i) + "】");
			} else {
				System.out.print("［" + player.hands.get(i) + "］");
			}
		}
		System.out.println();
	}

	public void allTurnEnd() {
		System.out.println("全員のターンが終了しました！手札をオープンします！");
	}

	public void allOpenAndScore(Player[] allPlayers) {
		for (Player player : allPlayers) {
			System.out.println(player.name + "'s hands and combo score ");
			handsDisplay(player);
			System.out.println(getComboName(player.comboScore));
			System.out.println();
		}
	}

	public void winnerDisplay(ArrayList<Player> winners) {
		System.out.println(winners.get(0).name + " win!");
		for (Card hand : winners.get(0).hands) {
			System.out.print("【" + hand + "】 ");
		}
	}

	public String getComboName(int comboScore) {
		switch (comboScore) {
		case 900:
			return "ロイヤルストレートフラッシュ！";
		case 800:
			return "ストレートフラッシュ！";
		case 700:
			return "フォーカード！";
		case 600:
			return "フルハウス！";
		case 550:
			return "フラッシュ！";
		case 500:
			return "ストレート！";
		case 450:
			return "スリーカード！";
		case 300:
			return "ツーペア！";
		case 150:
			return "ワンペア！";
		case 0:
			return "ハイカード！";
		default:
			return "おかしなことが起こった！";
		}
	}
}
