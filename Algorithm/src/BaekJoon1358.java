
import java.util.Scanner;

public class BaekJoon1358 {

	private static Scanner sc = null;

	private static int W;
	private static int H;
	private static int X;
	private static int Y;

	private static boolean inSquare(int x, int y) {
		if (X <= x && Y <= y && x <= X + W && y <= Y + H) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean inCircle1(int x, int y) {

		int dist = (x - X) * (x - X) + (y - Y - H / 2) * (y - Y - H / 2);

		if ((H / 2) * (H / 2) >= dist) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean inCircle2(int x, int y) {

		int dist = (x - X - W) * (x - X - W) + (y - Y - H / 2) * (y - Y - H / 2);

		if ((H / 2) * (H / 2) >= dist) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		int P = sc.nextInt();

		int cnt = 0;
		for (int i = 0; i < P; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (inSquare(x, y) || inCircle1(x, y) || inCircle2(x, y)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}