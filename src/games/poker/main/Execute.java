package games.poker.main;

public class Execute {
	Option option;

	public Execute(Option option) {
		this.option = option;
	}

	public void OpeningDraw(Board board) {
		System.out.println(option.getMaxHands());
		System.out.println(option.getMaxPlayer());
		for (int i = 0; i < option.getMaxPlayer(); i++) {
				board.players[i].openingDraw(board.deck);
		}
		for (int i = 0; i < option.getMaxDealer(); i++) {
			board.cpus[i].openingDraw(board.deck);
		}
	}
	
	public boolean allNotHold(Player[] players) {
		for(Player player : players) {
			if(!player.notHold) {
				return false;
			}
		}
		
		return true;
	}
	
}
