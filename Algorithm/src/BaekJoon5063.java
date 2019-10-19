import java.util.Scanner;

public class BaekJoon5063 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int r = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();

			int result = e - r - c;
			if (result > 0) {
				System.out.println("advertise");
			} else if (result == 0) {
				System.out.println("does not matter");
			} else {
				System.out.println("do not advertise");
			}
		}
	}
}