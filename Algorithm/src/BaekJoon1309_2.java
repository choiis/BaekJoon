import java.util.Scanner;

public class BaekJoon1309_2 {

	private static Scanner sc;

	private static final int DIV = 9901;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] dp = new int[N + 1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % DIV;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % DIV;
		}

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum = (sum + dp[N][i]) % DIV;
		}
		System.out.println(sum);
	}
}