
public class Fighter {
	String name;
	int damage;
	int health;
	int weight;
	int dodgePercent;

	Fighter(String name, int damage, int health, int weight, int dodgePercent) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.weight = weight;
		this.dodgePercent = dodgePercent;
	}

	int Hit(Fighter foe) {
		System.out.println(this.name + " hit " + foe.name + " with " + this.damage + " damage");
		if (foe.isDodge()) {
			System.out.println(foe.name + " dodged.");
			return foe.health;
		}
		if (foe.health <= this.damage) {
			return 0;
		}
		return foe.health - this.damage;
	}

	boolean isDodge() {
		double random = Math.random() * 101;
		return this.dodgePercent >= random;
	}

}