package Changable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class RandomGenerators {
	Random random = new Random();

	// Burası 20 ile x arasında bir sayı döner
	private int generateRandomNumber(int x) {
		int randomNumber;
		randomNumber = random.nextInt(21 - (x + 1)) + x + 1;
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
			Team t = new Team(generateRandomString(), generateRandomNumber(0), generateRandomNumber(0),
					generateRandomNumber(0), generateRandomNumber(0), generateRandomNumber(0), generatePlayers());

			teamArraylist.add(t);
		}
		return teamArraylist;
	}

//----------------------------------------------------------------
	public ArrayList<Player> generatePlayers() {

		ArrayList<Player> playersArraylist = new ArrayList<>();

		for (int i = 0; i < 25; i++) {
			PlayersFeatures features = new PlayersFeatures();

			int age = 19;
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
							int randomValue = generateRandomNumber(10);
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
				features.technical.Corners = generateRandomNumber(0);
				features.technical.FreeKickTaking = generateRandomNumber(0);
				features.technical.LongThrows = generateRandomNumber(0);
				features.technical.Marking = generateRandomNumber(0);
				features.technical.Tackling = generateRandomNumber(0);

				features.mental.Leadership = generateRandomNumber(0);
				features.mental.Positioning = generateRandomNumber(0);

			}
			if (position == "OrtaSaha") {
				features.technical.LongThrows = generateRandomNumber(0);
				features.technical.Marking = generateRandomNumber(0);

				features.mental.Concentration = generateRandomNumber(0);
				features.mental.WorkRate = generateRandomNumber(0);
			}
			if (position == "Savunma") {
				features.technical.Corners = generateRandomNumber(0);
				features.technical.Crossing = generateRandomNumber(0);
				features.technical.Dribbling = generateRandomNumber(0);
				features.technical.Finishing = generateRandomNumber(0);
				features.technical.FreeKickTaking = generateRandomNumber(0);
				features.technical.LongShots = generateRandomNumber(0);
				features.technical.LongThrows = generateRandomNumber(0);
				features.technical.PenaltyTaking = generateRandomNumber(0);
				features.technical.Technique = generateRandomNumber(0);

				features.mental.Flair = generateRandomNumber(0);
				features.mental.OfftheBall = generateRandomNumber(0);

			}
			if (position == "Kale") {
				features.technical.FreeKickTaking = generateRandomNumber(0);
				features.technical.PenaltyTaking = generateRandomNumber(0);

				features.mental.Aggression = generateRandomNumber(0);
				features.mental.Flair = generateRandomNumber(0);
				features.mental.OfftheBall = generateRandomNumber(0);
				features.mental.Vision = generateRandomNumber(0);

				features.physical.Acceleration = generateRandomNumber(0);
				features.physical.Pace = generateRandomNumber(0);

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

			double playersTechPower = (double) calculateTotalPower(features.technical) / 14;
			double playersMentalPower = (double) calculateTotalPower(features.mental) / 14;
			double playersPhysicalPower = (double) calculateTotalPower(features.physical) / 8;

			double playersTotalPower = (double) (playersTechPower + playersMentalPower + playersPhysicalPower) / 3;

			Player oyuncular = new Player(generateRandomString(), generateRandomNumber(age) + generateRandomNumber(0),
					playersPhysicalPower, playersMentalPower, playersTechPower, playersTotalPower, position, features);

			playersArraylist.add(oyuncular);
		}

		return playersArraylist;
	}

// ------------------------------------------------------
	PlayersFeatures features = new PlayersFeatures();

	private int calculateTotalPower(Object featureObject) {
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

//		ArrayList<Team> arrayExmp = new ArrayList<>();

		for (int i = 1; i < 18; i++) {
			System.out.println("\n" + i + ". Hafta\n");
			for (int j = 0; j < 18; j++) {

				System.out.println(j + " -> " + (i + j) % teamArray.size());
//				 j , (i+j) % teamArray.size();
			}

		}

	}

	// ------------------------------------------------------
	protected int theMatch(Team t1, Team t2) {
		if (t1.attackPower > t2.defencePower) {

			return 0;
		} else {
			return 1;
		}

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
