import java.util.Scanner;

public class BaekJoon11057 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int MOD = 10007;
		int[][] dp = new int[n][10];

		for (int i = 0; i <= 9; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0];
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
			}
		}
		int cnt = 0;
		for (int i = 0; i <= 9; i++) {
			cnt = (cnt + dp[n - 1][i]) % MOD;
		}
		System.out.println(cnt);
	}
}