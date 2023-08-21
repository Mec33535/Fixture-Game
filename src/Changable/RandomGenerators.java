package Changable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class RandomGenerators {
	Random random = new Random();

	// Burası 20 ile x arasında bir sayı döner
	private int generateRandomNumber(int x, int y) {
		int randomNumber;
		randomNumber = random.nextInt(x - (y + 1)) + y + 1;
		return randomNumber;
	}

//----------------------------------------------------------------
	private String generateRandomString() {
		String abc = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int lenght = 5;
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < lenght; i++) {
			int index = random.nextInt(abc.length());
			char character = abc.charAt(index);
			sBuilder.append(character);
		}
		return sBuilder.toString();
	}

//----------------------------------------------------------------
	public ArrayList<Team> generateTeam() {

		ArrayList<Team> teamArraylist = new ArrayList<>();

		for (int j = 0; j < 18; j++) {

//			Buraya teker teker güç ortalamaları eklenecek
			Team t = new Team(generateRandomString(), 0, 0, 0, generatePlayers());
			calculateTeamsPower(t);
			teamArraylist.add(t);
		}
		return teamArraylist;
	}

// ------------------------------------------------------
	// Bişiler yanlış. Çözemedim
	public void calculateTeamsPower(Team teamObject) {
		double totalAttack = 0;
		double totalDefence = 0;
		ArrayList<Player> oyuncular = teamObject.players;
		for (Player num : oyuncular) {
			if (num.position.equals("Hücum") || num.position.equals("OrtaSaha")) {
				totalAttack += num.totalPower;
			} else {
				totalDefence += num.totalPower;
			}
			teamObject.setAttackPower(totalAttack / 12);
			teamObject.setDefencePower(totalDefence / 13);
			teamObject.setTotalPower((totalAttack + totalDefence) / 25);

		}

//		return total / 12;

	}

//----------------------------------------------------------------
	public ArrayList<Player> generatePlayers() {

		ArrayList<Player> playersArraylist = new ArrayList<>();

		for (int i = 0; i < 25; i++) {
			PlayersFeatures features = new PlayersFeatures();

			String position = null;

			if (i < 6) {
				position = "Hücum";
			} else if (i < 12) {
				position = "OrtaSaha";
			} else if (i < 22) {
				position = "Savunma";
			} else if (i < 25) {
				position = "Kale";
			}

//			for (Field field : features.technical.getClass().getDeclaredFields()) {
//				if (field.getType() == int.class) {
//					try {
//						int randomValue = generateRandomNumber(10);
//						field.set(features.technical, randomValue);
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			for (Field field : features.physical.getClass().getDeclaredFields()) {
//				if (field.getType() == int.class) {
//					try {
//						int randomValue = generateRandomNumber(10);
//						field.set(features.physical, randomValue);
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			for (Field field : features.mental.getClass().getDeclaredFields()) {
//				if (field.getType() == int.class) {
//					try {
//						int randomValue = generateRandomNumber(10);
//						field.set(features.mental, randomValue);
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					}
//				}
//			}

			Object[] featureArray = { features.physical, features.mental, features.technical };

			for (Object fArrays : featureArray) {
				for (Field field : fArrays.getClass().getDeclaredFields()) {
					if (field.getType() == int.class) {
						try {
							int randomValue = generateRandomNumber(21, 10);
							field.set(fArrays, randomValue);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}

//			features.technical.Corners = generateRandomNumber(0);
//			features.technical.Crossing = generateRandomNumber(0);
//			features.technical.Dribbling = generateRandomNumber(0);
//			features.technical.Finishing = generateRandomNumber(0);
//			features.technical.FirstTouch = generateRandomNumber(0);
//			features.technical.FreeKickTaking = generateRandomNumber(0);
//			features.technical.Heading = generateRandomNumber(0);
//			features.technical.LongShots = generateRandomNumber(0);
//			features.technical.LongThrows = generateRandomNumber(0);
//			features.technical.Marking = generateRandomNumber(0);
//			features.technical.Passing = generateRandomNumber(0);
//			features.technical.PenaltyTaking = generateRandomNumber(0);
//			features.technical.Tackling = generateRandomNumber(0);
//			features.technical.Technique = generateRandomNumber(0);
//
//			features.physical.Acceleration = generateRandomNumber(0);
//			features.physical.Agility = generateRandomNumber(0);
//			features.physical.Balance = generateRandomNumber(0);
//			features.physical.JumpingReach = generateRandomNumber(0);
//			features.physical.NaturalFitness = generateRandomNumber(0);
//			features.physical.Pace = generateRandomNumber(0);
//			features.physical.Stamina = generateRandomNumber(0);
//			features.physical.Strength = generateRandomNumber(0);
//
//			features.mental.Aggression = generateRandomNumber(0);
//			features.mental.Anticipation = generateRandomNumber(0);
//			features.mental.Bravery = generateRandomNumber(0);
//			features.mental.Composure = generateRandomNumber(0);
//			features.mental.Concentration = generateRandomNumber(0);
//			features.mental.Decisions = generateRandomNumber(0);
//			features.mental.Determination = generateRandomNumber(0);
//			features.mental.Flair = generateRandomNumber(0);
//			features.mental.Leadership = generateRandomNumber(0);
//			features.mental.OfftheBall = generateRandomNumber(0);
//			features.mental.Positioning = generateRandomNumber(0);
//			features.mental.Teamwork = generateRandomNumber(0);
//			features.mental.Vision = generateRandomNumber(0);
//			features.mental.WorkRate = generateRandomNumber(0);

			if (position == "Hücum") {
				features.technical.Corners = generateRandomNumber(11, 0);
				features.technical.FreeKickTaking = generateRandomNumber(11, 0);
				features.technical.LongThrows = generateRandomNumber(11, 0);
				features.technical.Marking = generateRandomNumber(11, 0);
				features.technical.Tackling = generateRandomNumber(11, 0);

				features.mental.Leadership = generateRandomNumber(11, 0);
				features.mental.Positioning = generateRandomNumber(11, 0);

			}
			if (position == "OrtaSaha") {
				features.technical.LongThrows = generateRandomNumber(11, 0);
				features.technical.Marking = generateRandomNumber(11, 0);

				features.mental.Concentration = generateRandomNumber(11, 0);
				features.mental.WorkRate = generateRandomNumber(11, 0);
			}
			if (position == "Savunma") {
				features.technical.Corners = generateRandomNumber(11, 0);
				features.technical.Crossing = generateRandomNumber(11, 0);
				features.technical.Dribbling = generateRandomNumber(11, 0);
				features.technical.Finishing = generateRandomNumber(11, 0);
				features.technical.FreeKickTaking = generateRandomNumber(11, 0);
				features.technical.LongShots = generateRandomNumber(11, 0);
				features.technical.LongThrows = generateRandomNumber(11, 0);
				features.technical.PenaltyTaking = generateRandomNumber(11, 0);
				features.technical.Technique = generateRandomNumber(11, 0);

				features.mental.Flair = generateRandomNumber(11, 0);
				features.mental.OfftheBall = generateRandomNumber(11, 0);

			}
			if (position == "Kale") {
				features.technical.FreeKickTaking = generateRandomNumber(11, 0);
				features.technical.PenaltyTaking = generateRandomNumber(11, 0);

				features.mental.Aggression = generateRandomNumber(11, 0);
				features.mental.Flair = generateRandomNumber(11, 0);
				features.mental.OfftheBall = generateRandomNumber(11, 0);
				features.mental.Vision = generateRandomNumber(11, 0);

				features.physical.Acceleration = generateRandomNumber(11, 0);
				features.physical.Pace = generateRandomNumber(11, 0);

//				features.technical.Corners = generateRandomNumber(19);
//				features.technical.Corners
			}
//			int totalTech = 0;
//			for (Field field : features.technical.getClass().getDeclaredFields()) {
//				if (field.getType() == int.class) {
//					try {
//						int value = field.getInt(features.technical);
//						totalTech += value;
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			double techPower = (double) totalTech / 14;
//--------------------------------------------------------------------------------------

			double playersTechPower = (double) calculatePlayersPower(features.technical) / 14;
			double playersMentalPower = (double) calculatePlayersPower(features.mental) / 14;
			double playersPhysicalPower = (double) calculatePlayersPower(features.physical) / 8;

			double playersTotalPower = (double) (playersTechPower + playersMentalPower + playersPhysicalPower) / 3;

			Player oyuncular = new Player(generateRandomString(), generateRandomNumber(40, 20), playersPhysicalPower,
					playersMentalPower, playersTechPower, playersTotalPower, position, features);

			playersArraylist.add(oyuncular);
		}

		return playersArraylist;
	}

// ------------------------------------------------------
//	PlayersFeatures features = new PlayersFeatures();

	private int calculatePlayersPower(Object featureObject) {
		int total = 0;

		for (Field field : featureObject.getClass().getDeclaredFields()) {
			if (field.getType() == int.class) {
				try {
					int value = field.getInt(featureObject);
					total += value;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return total;
	}

//------------------------------------------------------

//	public ArrayList<ArrayList<Team>> createFixture(ArrayList<Team> teamArray) {
	public void createFixture(ArrayList<Team> teamArray) {

		for (int i = 1; i < 36; i++) {
			System.out.println("\n" + i + ". Hafta\n");
//			String m = null;
			for (int j = 0; j < 18; ++j) {

				if (i < 18) {
					teamArray.get(j).fanPower = true;
					teamArray.get((i + j) % teamArray.size()).fanPower = false;
				} else {
					teamArray.get(j).fanPower = false;
					teamArray.get((i + j) % 18).fanPower = true;
				}
				theMatch(teamArray.get(j), teamArray.get((i + j) % 18));
				System.out.println(j + " " + Boolean.toString(teamArray.get(j).fanPower) + " -> "
						+ Boolean.toString(teamArray.get((i + j) % 18).fanPower) + " " + (i + j) % teamArray.size());

//				System.out.println(theMatch(teamArray.get((i + j) % 18), teamArray.get(j)));
			}
		}
	}

	// ------------------------------------------------------
	public void theMatch(Team t1, Team t2) {

		double t1Attack = (t1.attackPower / t2.defencePower);
		double threshold = 0.8;
		for (int i = 0; i <= generateRandomNumber((int) t1.attackPower, 0); i++) {
			if (generateRandomNumber((int) t1Attack, 0) < threshold) {
				System.out.println("t1'den gol");
			}
		}
//		if()
//		return 0;
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
