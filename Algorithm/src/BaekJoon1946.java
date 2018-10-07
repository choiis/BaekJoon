
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1946 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			Rookie[] rookies = new Rookie[N];
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				rookies[i] = new Rookie(x, y);
			}
			Arrays.sort(rookies);
			int cnt = 1;
			int min = rookies[0].getY();
			for (int i = 1; i < N; i++) {
				if (rookies[i].getY() < min) {
					cnt++;
					min = rookies[i].getY();
				}
			}
			System.out.println(cnt);
		}
	}
}

class Rookie implements Comparable<Rookie> {
	private int x;
	private int y;

	public Rookie() {

	}

	public Rookie(int x, int y) {
		super();
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

	@Override
	public int compareTo(Rookie o) {
		return this.x - o.x;
	}

}