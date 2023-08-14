package Changable;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSection {

	public static void menuMethod() {
		System.out.println("\n#####---MENU---#####\n");
		System.out.println("1--) Oyuncu özellikleri ");
		System.out.println("2--) Takım özellikleri ");
		System.out.println("9--) Exit");
	}

	public static void main(String[] args) {

		RandomGenerators x = new RandomGenerators();
		int y = x.generateRandomNumber(10);

//		Player mesela = new Player(null, y, y, y, y, y, null, y);

		ArrayList<Player> z = x.generatePLayers();
		ArrayList<Object> teamsArayList = x.generateTeams();
		menuMethod();

		Scanner scanner = new Scanner(System.in);

		boolean menu = true;
		while (menu) {

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("## ÖRNEK OYUNCULAR MODELİ ## ");
				System.out.println();
				System.out.println("Name | Age | Physical | Mental | Technical | Keeper | TotalPower | Position");
				for (Player num : z) {
					System.out.println(num);
				}
				menuMethod();

				break;

			case 2:
				System.out.println("## ÖRNEK GENEL TAKIM MODELİ ## ");
				System.out.println();
				System.out.println("Name | TotalPower | DefencePower | AttackPower | MidfielderPower | FanPower ");

				for (Object num : teamsArayList) {
					System.out.println(num);

				}

				boolean secondMenu = true;
				while (secondMenu) {

					System.out.println("\n#####---TAKIM MENUSU---#####\n");
					System.out.println("1--) Takımın Oyuncuları.");
					System.out.println("2--) Seçenek A");
					System.out.println("3--) Seçenek B");
					System.out.println("4--) Seçenek C");
					System.out.println("9--) Ana Menüye Dön");
					char secondChoice = scanner.next().charAt(0);

					switch (secondChoice) {
					case '1':
						System.out.println("1----) Takım Oyuncuları.");
						break;
					case '2':
						System.out.println("Seçenek B seçildi.");
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
