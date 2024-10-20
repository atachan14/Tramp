package games.poker.main;

public class Cpu extends Player {

	public Cpu(Option option,int index) {
		super(option,index);
		this.name = "cpu"+(option.getMaxPlayer()+index+1);

	}
}
