package games.poker.main;

public class Option {
	int maxPlayer = 2;
	int maxCpu = 2;
	int maxReroll =8;
	int maxHands=10;

	public int getMaxPlayer() {
		return maxPlayer;
	}
	
	public int getMaxDealer() {
		return maxCpu;
	}

	public int getMaxReroll() {
		return maxReroll;
	}
	
	public int getMaxHands() {
		return maxHands;
	}
}
