package games.poker.main;

public class Board {
	Option option;
	Deck deck;
	Player[] players;
	Cpu[] cpus;
	Execute execute = new Execute(option);

	public Board(Option option) {
		this.option = option;
		deck = new Deck();
		players = new Player[option.getMaxPlayer()];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(option);
		}
		
		cpus = new Cpu[option.getMaxDealer()];
		for (int i = 0; i < cpus.length; i++) {
			cpus[i] = new Cpu(option);
		}
	}

	public void debug() {
		for (int i = 0; i < option.getMaxPlayer(); i++) {
			for (int j = 0; j < option.getMaxHands(); j++) {
				System.out.print(players[i].hands[j]+" ");
			}
			System.out.println();
		}
		for (int i = 0; i < option.getMaxPlayer(); i++) {
			for (int j = 0; j < option.getMaxHands(); j++) {
				System.out.print(cpus[i].hands[j]+" ");
			}
			System.out.println();
		}
		
	}
}
