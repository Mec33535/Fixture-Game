package Changable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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

	private double generateDoubleNumber(double x) {
		double randomDouble;
		randomDouble = random.nextDouble() * x;
		return randomDouble;
	}

// ----------------------------------------------------------------
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
				features.technical.Corners = generateRandomNumber(10, 0);
				features.technical.FreeKickTaking = generateRandomNumber(10, 0);
				features.technical.LongThrows = generateRandomNumber(10, 0);
				features.technical.Marking = generateRandomNumber(10, 0);
				features.technical.Tackling = generateRandomNumber(10, 0);

				features.mental.Leadership = generateRandomNumber(10, 0);
				features.mental.Positioning = generateRandomNumber(10, 0);

			}
			if (position == "OrtaSaha") {
				features.technical.LongThrows = generateRandomNumber(10, 0);
				features.technical.Marking = generateRandomNumber(10, 0);

				features.mental.Concentration = generateRandomNumber(10, 0);
				features.mental.WorkRate = generateRandomNumber(10, 0);
			}
			if (position == "Savunma") {
				features.technical.Corners = generateRandomNumber(10, 0);
				features.technical.Crossing = generateRandomNumber(10, 0);
				features.technical.Dribbling = generateRandomNumber(10, 0);
				features.technical.Finishing = generateRandomNumber(10, 0);
				features.technical.FreeKickTaking = generateRandomNumber(10, 0);
				features.technical.LongShots = generateRandomNumber(10, 0);
				features.technical.LongThrows = generateRandomNumber(10, 0);
				features.technical.PenaltyTaking = generateRandomNumber(10, 0);
				features.technical.Technique = generateRandomNumber(10, 0);

				features.mental.Flair = generateRandomNumber(10, 0);
				features.mental.OfftheBall = generateRandomNumber(10, 0);

			}
			if (position == "Kale") {
				features.technical.FreeKickTaking = generateRandomNumber(10, 0);
				features.technical.PenaltyTaking = generateRandomNumber(10, 0);

				features.mental.Aggression = generateRandomNumber(10, 0);
				features.mental.Flair = generateRandomNumber(10, 0);
				features.mental.OfftheBall = generateRandomNumber(10, 0);
				features.mental.Vision = generateRandomNumber(10, 0);

				features.physical.Acceleration = generateRandomNumber(10, 0);
				features.physical.Pace = generateRandomNumber(10, 0);

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

	HashMap<Integer, ArrayList<Team>> fixtureMap = new HashMap<>();

	public void createFixture(ArrayList<Team> teamArray) {
		// hangi takımın hangi takımla karşılaşacağının belirlenmesi var.TAMAM
		// 4-2 kazanan takım 3 puan alır. 2-4 kaybeden takım 0 puan alır. 4-2 kazanan
		// takımın averajı +2, kaybeden takımın averajı -2 olur.
		// averaj = attığın gol - yediğin gol
//		int count = 0;

		Collections.shuffle(teamArray);

		ArrayList<Team> myFixtureList = new ArrayList<>();
		myFixtureList.add(teamArray.get(0));
		for (int i = 1; i < 9; i++) {
			myFixtureList.add(teamArray.get(i));
		}
		for (int i = 0; i < 9; i++) {
			myFixtureList.add(teamArray.get((17 - i)));
		}

//		System.out.println("team");
//		for (Team team : teamArray) {
//
//			System.out.println(team);
//		}
//		System.out.println("fix");
//		for (Team fix : myFixtureList) {
//			System.out.println(fix);
//		}

		fixtureMap.put(0, myFixtureList);
		for (int i = 1; i < (teamArray.size() * 2); i++) {
			System.out.println(" ---------------");
			System.out.println("|                |");
			System.out.println("|" + "  HAFTA : " + (i < 10 ? "  " : " ") + i + "   |");
			System.out.println("|                |");
			System.out.println(" ---------------");

			fixtureMap.put(i, myFixtureList);
			if (i < 18) {

				for (int j = 0; j < 9; j++) {
					theMatch(fixtureMap.get(i).get(j), fixtureMap.get(i).get(17 - j));
					System.out.println("----------------");
					System.out.println(
							"   " + fixtureMap.get(i).get(j).goals + "  --  " + fixtureMap.get(i).get(17 - j).goals);
//					En son 8'e gelir	
					System.out.print(fixtureMap.get(i).get(j).name);
					System.out.print(" vs ");
//					En son 9 gelmesi lazım		
					System.out.println(fixtureMap.get(i).get(17 - j).name);
				}
			} else if (i == 18) {
				System.out.print("\nBreak\n");
			} else {
				for (int j = 0; j < 9; j++) {
					theMatch(fixtureMap.get(i % 18).get(17 - j), fixtureMap.get(i % 18).get(j));
					System.out.println("----------------");
					System.out.println("   " + fixtureMap.get(i % 18).get(17 - j).goals + "  --  "
							+ fixtureMap.get(i % 18).get(j).goals);
//				En son 8'e gelir	
					System.out.print(fixtureMap.get(i % 18).get(17 - j).name);
					System.out.print(" vs ");
//				En son 9 gelmesi lazım		
					System.out.println(fixtureMap.get(i % 18).get(j).name);
//					System.out.println("-------------------------------");
				}
			}

			Team lastElement = myFixtureList.get(17);
			myFixtureList.remove(17);
			myFixtureList.add(1, lastElement);
		}

//		System.out.println("team");
//		for (Team team : teamArray) {
//
//			System.out.println(team);
//		}
//		System.out.println("fix");
//		for (Team fix : myFixtureList) {
//			System.out.println(fix);
//		}
	}

//		
//		
//		
//		
//		
//		
//		for (int i = 1; i < 36; i++) {
//			System.out.println("\n" + i + ". Hafta\n");
////			String m = null;
//			for (int j = 0; j < 18; ++j) {
//
//				if (i < 18) {
//					teamArray.get(j).fanPower = true;
//					teamArray.get((i + j) % teamArray.size()).fanPower = false;
//				} else {
//					teamArray.get(j).fanPower = false;
//					teamArray.get((i + j) % 18).fanPower = true;
//				}
//
//				theMatch(teamArray.get(j), teamArray.get((i + j) % 18));
//
//				System.out.println(j + " " + Boolean.toString(teamArray.get(j).fanPower) + " -> "
//						+ Boolean.toString(teamArray.get((i + j) % 18).fanPower) + " " + (i + j) % teamArray.size());
//
//			}
//		}
//	}

	// ------------------------------------------------------
	public void theMatch(Team t1, Team t2) {

		double t1Attack = (t1.attackPower / t2.defencePower);
		double t2Attack = (t2.attackPower / t1.defencePower);
		double threshold = 0.8;
		int t1sGoal = 0;
		int t1sLoss = 0;
		int t2sGoal = 0;
		int t2sLoss = 0;

		// t1'in atak sayısı
		for (int i = 0; i <= generateRandomNumber((int) t1.attackPower, 0); i++) {
//			System.out.println(t1.name + " İsimli Takımın Hücumu ");
			// 1.2 ile çarpılır çünkü t1 her zaman ev takımı
			if ((generateDoubleNumber(t1Attack) * 1.2) > threshold) {
				t1sGoal += 1;
			} else {
				t1sLoss += 1;
			}
		}
		// t2'nin atak sayısı
		for (int i = 0; i <= generateRandomNumber((int) t2.attackPower, 0); i++) {
//			System.out.println(t2.name + " İsimli Takımın Hücumu ");
			if ((generateDoubleNumber(t2Attack)) > threshold) {
				t2sGoal += 1;
			} else {
				t2sLoss += 1;
			}
		}

//		System.out.println(t1.name + " Home Goal => " + t1sGoal + " !!! ");
//		System.out.println(t1.name + " Home Loss => " + t1sLoss);
//		System.out.println(t2.name + " OPP Goal => " + t2sGoal + " !!! ");
//		System.out.println(t2.name + " OPP Loss => " + t2sLoss);
//		System.out.print("----------------------");

		t1.setGoals(t1sGoal);
		t2.setGoals(t2sGoal);
		int avgt1 = t1.avg;
		int avgt2 = t2.avg;

		avgt1 += (t1sGoal - t2sGoal);
		avgt2 += (t2sGoal - t1sGoal);

		t1.setAvg(avgt1);
		t2.setAvg(avgt2);
		int puant1 = t1.points;
		int puant2 = t2.points;

		if (t1sGoal > t2sGoal) {
			t1.setPoints(puant1 + 3);
//			t2.setPoints(puant2 - 2);
		} else if (t1sGoal == t2sGoal) {
			t1.setPoints(puant1 + 1);
			t2.setPoints(puant2 + 1);
		} else {
//			t1.setPoints(puant1 - 2);
			t2.setPoints(puant2 + 3);
		}
	}

// ------------------------------------------------------
	public void theScoreBoard(ArrayList<Team> teamArray) {
//		for (int i = 1; i < (teamArray.size() * 2); i++) {
//			System.out.println("    " + i + ".Hafta");
		Collections.sort(fixtureMap.get(0), new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {

				if (o2.getPoints() == o1.getPoints()) {
					return o2.getAvg() - o1.getAvg();
				}
				return o2.getPoints() - o1.getPoints();
			}
		});
		for (int j = 0; j < 18; j++) {

			System.out.println();
			Team gs = fixtureMap.get(0).get(j);

			System.out.println(gs.name + " Puanlar -> " + gs.points + " Averaj -> " + gs.avg);
//			System.out.println("AVERAJLAR =>   " + fixtureMap.get(0).get(j).avg);
//				System.out.println(fix);
//			}
		}
//		for (Team takim : teamArray) {
//			System.out.println("Takım adı: " + takim.name);
//		}

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
