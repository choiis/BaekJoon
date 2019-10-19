import java.util.Scanner;

public class BaekJoon2482 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		// N까지 K개색 선택
		int[][] dp = new int[N + 1][N + 1];

		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				// i-1까지 j개선택 or i-2까지 j-1개 + i에서 한개선택
				dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % DIV;
			}
		}

		System.out.println((dp[N - 3][K - 1] + dp[N - 1][K]) % DIV);
	}

	private static int DIV = 1000000003;
}