package Changable;

import java.util.ArrayList;

public class Team {
//	Player players = new Player(null, 0, 0, 0, 0, 0, null);

	RandomGenerators x = new RandomGenerators();
	ArrayList<Player> Team = x.generatePLayers();

//private Players[];
	Integer totalPower, defencePower, attackPower, midfielderPower, fanPower;
	String name;
//	Player players;
	ArrayList<Object> players;

	Team(String name, Integer totalPower, Integer defencePower, Integer attackPower, Integer midfielderPower,
			Integer fanPower, ArrayList<Object> players) {
		this.name = name;
		this.totalPower = totalPower;
		this.defencePower = defencePower;
		this.attackPower = attackPower;
		this.midfielderPower = midfielderPower;
		this.fanPower = fanPower;

		this.players = players;
	}

	@Override
	public String toString() {
		return name + "     " + (totalPower < 10 ? " " : "") + totalPower + "            "
				+ (defencePower < 10 ? " " : "") + defencePower + "              " + (attackPower < 10 ? " " : "")
				+ attackPower + "            " + (midfielderPower < 10 ? " " : "") + midfielderPower + "            "
				+ (fanPower < 10 ? " " : "") + fanPower;
	}
//	public Team (Object[] x , ) {
//		 
//	 }

}