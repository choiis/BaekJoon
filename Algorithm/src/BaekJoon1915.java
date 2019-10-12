import java.util.Scanner;

public class BaekJoon1915 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] square = new char[N][M];
		int[][] dp = new int[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			square[i] = str.toCharArray();
			for (int j = 0; j < M; j++) {
				if (square[i][j] == '1') {
					dp[i][j] = 1;
					cnt = 1;
				}
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if (square[i - 1][j] == '1' && square[i][j - 1] == '1' && square[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					cnt = Math.max(cnt, dp[i][j]);
				}
			}
		}
		System.out.println(cnt * cnt);
	}
}