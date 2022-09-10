
public class Main {

	public static void main(String[] args) {
		Fighter marc = new Fighter("Marc", 10, 100, 90, 50);
		Fighter alex = new Fighter("Alex", 15, 95, 100, 40);
		Ring r = new Ring(marc, alex, 90, 100);
		r.run();
	}

}