import java.util.Scanner;

public class BaekJoon1563 {

	private static Scanner sc;

	private static int[][][] dp;

	private static int N;

	private static int prize(int date, int late, int absence) {
		if (late == 2 || absence == 3) {
			return 0;
		} else if (date == N) {
			return 1;
		}

		int val = dp[date][late][absence];
		if (val != -1) {
			return val;
		}
		val = 0;

		val += prize(date + 1, late + 1, 0) + prize(date + 1, late, absence + 1) + prize(date + 1, late, 0);

		return val % 1000000;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[N][2][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(prize(0, 0, 0));
	}
}