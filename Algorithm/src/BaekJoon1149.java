import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1149 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1149.txt"));

		int N = sc.nextInt();
		int[][] color = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			color[i][0] = sc.nextInt();
			color[i][1] = sc.nextInt();
			color[i][2] = sc.nextInt();
		}

		dp[0][0] = color[0][0];
		dp[0][1] = color[0][1];
		dp[0][2] = color[0][2];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1] + color[i][0], dp[i - 1][2] + color[i][0]);
			dp[i][1] = Math.min(dp[i - 1][0] + color[i][1], dp[i - 1][2] + color[i][1]);
			dp[i][2] = Math.min(dp[i - 1][1] + color[i][2], dp[i - 1][0] + color[i][2]);
		}

		int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		System.out.println(result);
	}
}