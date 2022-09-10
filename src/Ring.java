
public class Ring {
	Fighter f1;
	Fighter f2;
	int minWeight;
	int maxWeight;

	Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
		this.f1 = f1;
		this.f2 = f2;
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
	}

	void run() {
		if (checkWeight()) {
			int round = 1;
			System.out.println(
					"Starting Health Info: " + f1.name + " -> " + f1.health + "\t" + f2.name + " -> " + f2.health);
			while (f1.health > 0 && f2.health > 0) {
				System.out.println("\n///////////////////////ROUND " + round + "/////////////////////");
				double who_will_hit = whoHit();
				if (who_will_hit == 1.0) {
					f2.health = f1.Hit(f2);
					if (isWin())
						break;
				}
				if (who_will_hit == 2.0) {
					f1.health = f2.Hit(f1);
					if (isWin())
						break;
				}
				round++;
				printScore();
			}
		} else {
			System.out.println("The weights do not match!!!");
		}

	}

	boolean checkWeight() {
		return ((f1.weight >= this.minWeight && f1.weight <= this.maxWeight)
				&& (f2.weight >= this.minWeight && f2.weight <= this.maxWeight));
	}

	double whoHit() {
		return (Math.floor(Math.random() * 2) + 1);
	}

	boolean isWin() {
		if (f1.health == 0) {
			System.out.println("*********************************************");
			System.out.println(f2.name + " won with " + f2.health + " health.");
			return true;
		}
		if (f2.health == 0) {
			System.out.println("*********************************************");
			System.out.println(f1.name + " won with " + f1.health + " health.");
			return true;
		}
		return false;
	}

	void printScore() {
		System.out.println("\t" + f1.name + " health is " + f1.health);
		System.out.println("\t" + f2.name + " health is " + f2.health);
	}
}