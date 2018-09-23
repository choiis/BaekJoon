import java.util.Scanner;

public class BaekJoon1309 {

	private static Scanner sc;

	private static final int DIV = 9901;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			dp[i][1] = 2 * i;
			dp[i][i] = 2;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (dp[i][j] == 0) {
					dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1] + dp[i - 2][j - 1]) % DIV;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i <= N; i++) {
			sum = (sum + dp[N][i]) % DIV;
		}
		System.out.println(sum);
	}
}