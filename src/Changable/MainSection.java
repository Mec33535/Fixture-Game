package Changable;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSection {

	public static void menuMethod() {
		System.out.println("\n#####---MENU---#####\n");
		System.out.println("1--) Takım Gösterimi\n ");
		System.out.println("2--) Örnek Oyuncu Modeli\n");
		System.out.println("9--) Exit\n");
	}

	public static void main(String[] args) {

		RandomGenerators x = new RandomGenerators();
		ArrayList<Player> z = x.generateTeams();
		PlayersFeatures features = new PlayersFeatures();

		ArrayList<Team> teamsArayList = x.generatele();

//		ArrayList<Player> a  = teamsArayList.indexOf(-1);
		menuMethod();

		Scanner scanner = new Scanner(System.in);

		boolean menu = true;
		while (menu) {

			int choice = scanner.nextInt();
			switch (choice) {

			case 1:
				System.out.println("## GENEL TAKIM GÖSTERİMİ## ");
				System.out.println();
				System.out.println("Name | TotalPower | DefencePower | AttackPower | MidfielderPower | FanPower ");

				for (Object num : teamsArayList) {
					System.out.println(num);

				}

				boolean secondMenu = true;
				while (secondMenu) {

					System.out.println("\n#####---TAKIM MENUSU---#####\n");
					System.out.println("1--) Takımın Oyuncuları.");
					System.out.println("2--) Takım Oyuncularının Özellik Tabloları.");
					System.out.println("3--) Seçenek B");
					System.out.println("4--) Seçenek C");
					System.out.println("9--) Ana Menüye Dön");
					char secondChoice = scanner.next().charAt(0);

					switch (secondChoice) {
					case '1':
						System.out.println("1----) Takım Oyuncuları.");
						System.out.println("Hangi Takımın Oyuncularını Görmek İstiyorsunuz ?");
						System.out.println("0'dan Başlayacak Şekilde Index Veriniz!");

						int selectedTeamIndexForTeam = scanner.nextInt();
						Team choosenTeam = teamsArayList.get(selectedTeamIndexForTeam);

						ArrayList<Player> choosemTeamsPlayers = choosenTeam.players;
						System.out.println("İsimi: " + choosenTeam.name + " olan rakımın oyuncuları : ");
						System.out
								.println("Name | Age | Physical | Mental | Technical | Keeper | TotalPower | Position");
						for (Object num : choosemTeamsPlayers)
							System.out.println(num);

//						for (Object num : oç)
//							System.out.println(num);

						break;
					case '2':
						System.out.println("2----) Takım Oyuncularının Özellik Tabloları.");
						System.out.println("Hangi Takımın Oyuncularının Özelliklerini Görmek İstiyorsunuz ?");
						System.out.println("0'dan Başlayacak Şekilde Index Veriniz!");

						int selectedTeamIndexForFeatures = scanner.nextInt();
						// burada j hangi takım demekken, i, takımdaki hangi eleman demektir ?
						System.out.println("\n" + teamsArayList.get(selectedTeamIndexForFeatures).name
								+ " İsimli Takımın Oyuncularının Özellikleri:  \n");
						System.out.println("physical | Mental | vs");
						for (int i = 0; i < 24; i++) {
							// players yerine bir method yaz ki burada yazanları printlemeyi sağlasın
							ArrayList<Player> anlamadim = teamsArayList.get(selectedTeamIndexForFeatures).players;
							System.out.print("Oyuncu ismi: " + anlamadim.get(i).name + " => ");
							System.out.println(anlamadim.get(i).features + " => " + anlamadim.get(i).position + " ");
						}

//							System.out.println(teamsArayList.get(selectedTeamIndexForFeatures).players.get(i).features);

						// Burası da direkt mental vs yazdırmak için. Kullanılır
//						ArrayList<Player> anlamadim = teamsArayList.get(selectedTeamIndexForFeatures).players;
//						System.out.println(anlamadim.get(0).features.mental);

						break;
					case '3':
						System.out.println("Seçenek C seçildi.");
						break;
					case '9':
						secondMenu = false;
						break;
					default:
						System.out.println("Geçersiz seçenek.");
						break;
					}
				}

				menuMethod();
				break;

			case 2:
				System.out.println("## ÖRNEK OYUNCULAR MODELİ ## ");
				System.out.println();
				System.out.println("Name | Age | Physical | Mental | Technical | Keeper | TotalPower | Position");

				for (Player num : z) {
					System.out.println(num);
				}

				menuMethod();

				break;

			case 9:
				System.out.println("Çıkış yapılıyor...");
				menu = false;
				break;

			default:
				System.out.println("Yanlış giriş yaptınız. Lütfen tekrar seçim yapınız.");
				menuMethod();
				break;
			}
		}
		scanner.close();

	}
}
