import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon10272 {

	private static Scanner sc = null;

	private static int[] x = null;
	private static int[] y = null;

	private static double[][] dp = null;

	private static int N;

	private static double distance(int a, int b) {
		return Math.sqrt((x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b]));
	}

	private static double find_min(int left, int right) {
		if (right == N - 1) {
			return distance(left, right);
		} else if (dp[left][right] != 0) {
			return dp[left][right];
		} else {
			return dp[left][right] = Math.min(find_min(left, right + 1) + distance(right, right + 1),
					find_min(right, right + 1) + distance(left, right + 1));
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon10272.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			x = new int[N + 1];
			y = new int[N + 1];
			dp = new double[N + 1][N + 1];

			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}

			System.out.println(find_min(0, 0));
		}
	}
}