package Changable;

public class Player {

	String name, position;
	int age, physical, mental, technical, keeper, totalPower;

	PlayersFeatures features;

	Player(String name, int age, int physical, int mental, int techincal, int keeper, int totalPower, String position,
			PlayersFeatures features) {
		this.name = name;
		this.age = age;
		this.physical = physical;
		this.mental = mental;
		this.technical = techincal;
		this.keeper = keeper;
		this.totalPower = totalPower;
		this.position = position;
		this.features = features;
	}

	@Override
	public String toString() {
		return name + "  " + (age < 10 ? " " : "") + age + "      " + (physical < 10 ? " " : "") + physical + "        "
				+ (mental < 10 ? " " : "") + mental + "        " + (technical < 10 ? " " : "") + technical + "         "
				+ (keeper < 10 ? " " : "") + keeper + "         " + (totalPower < 10 ? " " : "") + totalPower
				+ "         " + position.toString();
	}

//	public int generatePower(int x, int y) {
//
//		return physical + technical + keeper + (x / 2) + (y / 2);
//
//	}

//	RandomGenerators rr = new RandomGenerators();
//	PlayersFeatures playerFeature = new PlayersFeatures();
//	PlayersFeatures.Technical t = playerFeature.new Technical(rr.generateRandomNumber(0), rr.generateRandomNumber(0),
//			rr.generateRandomNumber(0), age, age, age, age, age, totalPower, physical, mental, keeper, age, technical);

}

class PlayersFeatures {
	Technical technical = new Technical();
	Mental mental = new Mental();
	Physical physical = new Physical();

	@Override
	public String toString() {
		return " |T| -> " + technical.toString() + "  |P| -> " + physical.toString() + " |M| ->" + mental.toString();

	}

	class Technical {

		int Corners, Crossing, Dribbling, Finishing, FirstTouch, FreeKickTaking, Heading, LongShots, LongThrows,
				Marking, Passing, PenaltyTaking, Tackling, Technique;

//		Technical(int Corners, int Crossing, int Dribbling, int Finishing, int FirstTouch, int FreeKickTaking,
//				int Heading, int LongShots, int LongThrows, int Marking, int Passing, int PenaltyTaking, int Tackling,
//				int Technique) {
//
//			this.Corners = Corners;
//			this.Crossing = Crossing;
//			this.Dribbling = Dribbling;
//			this.Finishing = Finishing;
//			this.FirstTouch = FirstTouch;
//			this.FreeKickTaking = FreeKickTaking;
//			this.Heading = Heading;
//			this.LongShots = LongShots;
//			this.LongThrows = LongThrows;
//			this.Marking = Marking;
//			this.Passing = Passing;
//			this.PenaltyTaking = PenaltyTaking;
//			this.Tackling = Tackling;
//			this.Technique = Technique;
//		}

		@Override
		public String toString() {
//			return Corners + " " + Crossing + " " + Dribbling + " " + Finishing + " " + FirstTouch + " "
//					+ FreeKickTaking + " " + Heading + " " + LongShots + " " + LongThrows + " " + Marking + " "
//					+ Passing + " " + PenaltyTaking + " " + Tackling + " " + Technique;
			return (Corners < 10 ? "  " : " ") + Corners + "   " + (Crossing < 10 ? "  " : " ") + Crossing + "   "
					+ (Dribbling < 10 ? "  " : " ") + Dribbling + "   " + (Finishing < 10 ? "  " : " ") + Finishing
					+ "   " + (FirstTouch < 10 ? "  " : " ") + FirstTouch + "   " + (FreeKickTaking < 10 ? "  " : " ")
					+ FreeKickTaking + "   " + (Heading < 10 ? "  " : " ") + Heading + "   "
					+ (LongShots < 10 ? "  " : " ") + LongShots + "   " + (LongThrows < 10 ? "  " : " ") + LongThrows
					+ "   " + (Marking < 10 ? "  " : " ") + Marking + "   " + (Passing < 10 ? "  " : " ") + Passing
					+ "   " + (PenaltyTaking < 10 ? "  " : " ") + PenaltyTaking + "   " + (Tackling < 10 ? "  " : " ")
					+ Tackling + "   " + (Technique < 10 ? " " : "") + Technique;
		}
	}

	class Mental {

		int Aggression, Anticipation, Bravery, Composure, Concentration, Decisions, Determination, Flair, Leadership,
				OfftheBall, Positioning, Teamwork, Vision, WorkRate;

//		Mental(int Aggression, int Anticipation, int Bravery, int Composure, int Concentration, int Decisions,
//				int Determination, int Flair, int Leadership, int OfftheBall, int Positioning, int Teamwork, int Vision,
//				int WorkRate) {
//
//			this.Aggression = Aggression;
//			this.Anticipation = Anticipation;
//			this.Bravery = Bravery;
//			this.Composure = Composure;
//			this.Concentration = Concentration;
//			this.Decisions = Decisions;
//			this.Determination = Determination;
//			this.Flair = Flair;
//			this.Leadership = Leadership;
//			this.OfftheBall = OfftheBall;
//			this.Positioning = Positioning;
//			this.Teamwork = Teamwork;
//			this.Vision = Vision;
//			this.WorkRate = WorkRate;
//
//		}

		@Override
		public String toString() {
			return (Aggression < 10 ? "  " : " ") + Aggression + "   " + (Anticipation < 10 ? "  " : " ") + Anticipation
					+ "   " + (Bravery < 10 ? "  " : " ") + Bravery + "   " + (Composure < 10 ? "  " : " ") + Composure
					+ "   " + (Concentration < 10 ? "  " : " ") + Concentration + "   " + (Decisions < 10 ? "  " : " ")
					+ Decisions + "   " + (Determination < 10 ? "  " : " ") + Determination + "   "
					+ (Flair < 10 ? "  " : " ") + Flair + "   " + (Leadership < 10 ? "  " : " ") + Leadership + "   "
					+ (OfftheBall < 10 ? "  " : " ") + OfftheBall + "   " + (Positioning < 10 ? "  " : " ")
					+ Positioning + "   " + (Teamwork < 10 ? "  " : " ") + Teamwork + "   " + (Vision < 10 ? "  " : " ")
					+ Vision + "   " + (WorkRate < 10 ? " " : "") + WorkRate;
		}

	}

	class Physical {

		int Acceleration, Agility, Balance, JumpingReach, NaturalFitness, Pace, Stamina, Strength;

//		Physical(int Acceleration, int Agility, int Balance, int JumpingReach, int NaturalFitness, int Pace,
//				int Stamina, int Strength) {
//			this.Acceleration = Acceleration;
//			this.Agility = Agility;
//			this.Balance = Balance;
//			this.JumpingReach = JumpingReach;
//			this.NaturalFitness = NaturalFitness;
//			this.Pace = Pace;
//			this.Stamina = Stamina;
//			this.Strength = Strength;
//		}

		@Override
		public String toString() {
//			return Acceleration + " " + Agility + " " + Balance + " " + JumpingReach + " " + NaturalFitness + " " + Pace
//					+ " " + Stamina + " " + Strength;
//			
			return (Acceleration < 10 ? "  " : " ") + Acceleration + "   " + (Agility < 10 ? "  " : " ") + Agility
					+ "   " + (Balance < 10 ? "  " : " ") + Balance + "   " + (JumpingReach < 10 ? "  " : " ")
					+ JumpingReach + "   " + (NaturalFitness < 10 ? "  " : " ") + NaturalFitness + "   "
					+ (Pace < 10 ? "  " : " ") + Pace + "   " + (Stamina < 10 ? "  " : " ") + Stamina + "   "
					+ (Strength < 10 ? "  " : " ") + Strength;
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
