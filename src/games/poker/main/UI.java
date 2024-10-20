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
		for (Card all : player.hands)
			System.out.print("【" + all + "】 ");
	}

	public void afterDisplay(Player player, ArrayList<Integer> indexs) {
		if (player.hold == true)
			return; // holdなら非表示

		for (int i = 0; i < player.hands.length; i++) {
			if (indexs.contains(i)) {
				System.out.print("【" + player.hands[i] + "】 ");
			} else {
				System.out.print("[" + player.hands[i] + "] ");
			}
		}
		System.out.println();
		System.out.println();
	}
}
