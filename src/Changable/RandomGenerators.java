package Changable;

import java.util.ArrayList;
import java.util.Random;

public class RandomGenerators {

//	int tekteInt;

	Random random = new Random();

//	public int generateRandomNumber(int x) {
////		return random.nextInt(x) + 1;
//		int randomNumber = random.nextInt(x + 20) + 1;
//		if (randomNumber > 20) {
//			randomNumber = 20;
//		}
//		return randomNumber;
//	}
//----------------------------------------------------------------
	// Burası 20 ile x arasında bir sayı döner
	public int generateRandomNumber(int x) {
		int randomNumber;
		randomNumber = random.nextInt(21 - (x + 1)) + x + 1;
		return randomNumber;
	}

//----------------------------------------------------------------
	public int generateGüç(int x) {

		return 6;
	}

//----------------------------------------------------------------
	public StringBuilder generateRandomString() {
		String abc = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int lenght = 5;
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < lenght; i++) {
			int index = random.nextInt(abc.length());
			char character = abc.charAt(index);
			sBuilder.append(character);
		}
		return sBuilder;
	}

//----------------------------------------------------------------
	public ArrayList<Player> generatePLayers() {

		Player oyuncular = new Player(null, 0, 0, 0, 0, 0, 0, null);
		ArrayList<Player> playersArrayList = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 25; i++) {
			int age = 19, physical = 0, mental = 0, technical = 0, keeper = 0;
//			Player mesela = null;
			String position = null;
			if (i < 6) {
				position = "Hücum";

				x = physical;
				y = technical;
				physical = 10;
				technical = 10;

			} else if (i < 12) {
				position = "OrtaSaha";

				x = technical;
				y = mental;
				technical = 10;
				mental = 10;
			} else if (i < 22) {
				position = "Savunma";

				x = physical;
				y = keeper;
				physical = 10;
				keeper = 10;
			} else if (i < 25) {
				position = "Kale";

				x = keeper;
				y = mental;
				keeper = 10;
				mental = 10;
			}
//			int totalpower = mesela.generatePower(5);
//			mesela = new Player(generateRandomString().toString(), generateRandomNumber(age) + generateRandomNumber(0),
//					generateRandomNumber(physical), generateRandomNumber(mental), generateRandomNumber(technical),
//					generateRandomNumber(keeper), totalpower, position);
			int powerVariable = oyuncular.generatePower(x, y);
			oyuncular = new Player(generateRandomString().toString(),
					generateRandomNumber(age) + generateRandomNumber(0), generateRandomNumber(physical),
					generateRandomNumber(mental), generateRandomNumber(technical), generateRandomNumber(keeper),
					powerVariable, position);
//			System.out.println("oyuncular" + oyuncular.generatePower(5, 2));
			playersArrayList.add(oyuncular);
		}
		return playersArrayList;
	}
	// ------------------------------------------------------

	public ArrayList<Object> generateTeams() {
		ArrayList<Object> TeamArrayList = new ArrayList<>();
//		ArrayList<Team> TeamArrayList1 = new ArrayList<>(generatePLayers());
		for (int i = 0; i < 18; i++) {
			int x = 5;
//			takim.players = TeamArrayList;
			Team takim = new Team(generateRandomString().toString(), generateRandomNumber(x), generateRandomNumber(x),
					generateRandomNumber(x), generateRandomNumber(x), generateRandomNumber(x), TeamArrayList);

			TeamArrayList.add(takim);

		}
		return TeamArrayList;
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
//
