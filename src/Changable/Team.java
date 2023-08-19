package Changable;

import java.util.ArrayList;

public class Team {

	Integer totalPower, defencePower, attackPower, midfielderPower, fanPower;
	String name;
	ArrayList<Player> players;

	Team(String name, Integer totalPower, Integer defencePower, Integer attackPower, Integer midfielderPower,
			Integer fanPower, ArrayList<Player> players) {
		this.name = name;
		this.totalPower = totalPower;
		this.defencePower = defencePower;
		this.attackPower = attackPower;
		this.fanPower = fanPower;
		this.midfielderPower = midfielderPower;

		this.players = players;
	}

	@Override
	public String toString() {
		return "Takım adı: " + name + " =>    " + (totalPower < 10 ? " " : "") + totalPower + "            "
				+ (defencePower < 10 ? " " : "") + defencePower + "              " + (attackPower < 10 ? " " : "")
				+ attackPower + "            " + (midfielderPower < 10 ? " " : "") + midfielderPower + "            "
				+ (fanPower < 10 ? " " : "") + fanPower + " ";
	}
}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
