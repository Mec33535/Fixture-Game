package Changable;

import java.util.ArrayList;

public class Team {
	boolean fanPower;
	double totalPower, defencePower, attackPower;
	String name;
	ArrayList<Player> players;

	Team(String name, double attackPower, double defencePower, double totalPower, ArrayList<Player> players) {
		this.name = name;
		this.attackPower = attackPower;
		this.defencePower = defencePower;
		this.totalPower = totalPower;

		this.players = players;
	}

	@Override
	public String toString() {
		return "Takım adı: " + name + " =>   " + (totalPower < 10 ? " " : "") + String.format("%.2f", totalPower)
				+ "         " + (defencePower < 10 ? " " : "") + String.format("%.2f", defencePower) + "         "
				+ (attackPower < 10 ? " " : "") + String.format("%.2f", attackPower) + "      " + fanPower + " ";
	}

	public void setAttackPower(double attackPower) {
		this.attackPower = attackPower;
	}

	public void setDefencePower(double defencePower) {
		this.defencePower = defencePower;
	}

	public void setTotalPower(double totalPower) {
		this.totalPower = totalPower;
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
