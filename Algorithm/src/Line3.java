import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Line3 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("line3.txt"));

		int N = sc.nextInt();
		Vector<Relation> vector = new Vector<Relation>();
		Set<Integer> friends = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Relation relation1 = new Relation(x, y);
			Relation relation2 = new Relation(y, x);
			friends.add(x);
			friends.add(y);
			vector.add(relation1);
			vector.add(relation2);
		}
	}
}



class Relation {
	private int x;
	private int y;

	public Relation() {

	}

	public Relation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}