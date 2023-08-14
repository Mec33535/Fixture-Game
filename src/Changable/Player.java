package Changable;

public class Player {

	String name, position;
	int age, physical, mental, technical, keeper, totalPower;

	Player(String name, int age, int physical, int mental, int techincal, int keeper, int totalPower, String position) {
		this.name = name;
		this.age = age;
		this.physical = physical;
		this.mental = mental;
		this.technical = techincal;
		this.keeper = keeper;
		this.totalPower = totalPower;
		this.position = position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return name + "  " + (age < 10 ? " " : "") + age + "      " + (physical < 10 ? " " : "") + physical + "        "
				+ (mental < 10 ? " " : "") + mental + "        " + (technical < 10 ? " " : "") + technical + "         "
				+ (keeper < 10 ? " " : "") + keeper + "         " + (totalPower < 10 ? " " : "") + totalPower
				+ "         " + position;
	}
	// Bana posizyonlarına göre player'ların power kazanması lazım
	// Fonksiyon her değerden 1x güçlü olduklarından 1.5x şeklinde olabilir.

	public int generatePower(int x, int y) {

		return physical + mental + technical + keeper + (x / 2) + (y / 2);

	}
}
