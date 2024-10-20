package games.poker.main;

public class Menu {

	public void opening() {
		System.out.println("---------------------");
		System.out.println();
		System.out.println();
		System.out.println("	poker");
		System.err.println();
		System.out.println();
	}

	public void mainMenu() {
		Option option = new Option();
		System.out.println("---------------------");
		System.out.println("1.play");
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			PokerManager pokerManager = new PokerManager(option);
			pokerManager.startGame();
		}
	}
}
