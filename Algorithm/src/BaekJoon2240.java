import java.util.Scanner;

public class BaekJoon2240 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int W = sc.nextInt();
		int[][][] dp = new int[T + 1][2][W + 2];
		// [½Ã°£][1 2Ä­][ÀÌµ¿È½¼ö]
		int[] jadu = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			jadu[i] = sc.nextInt();
		}

		for (int i = 1; i <= T; i++) {
			for (int j = 1; j <= W + 1; j++) {
				if (jadu[i] == 1) {
					dp[i][0][j] = Math.max(dp[i - 1][0][j] + 1, dp[i - 1][1][j - 1] + 1);
					dp[i][1][j] = Math.max(dp[i - 1][0][j - 1], dp[i - 1][1][j]);
				} else {
					if (i == 1 && j == 1) { // ¸ÇÃ³À½¿£ 1¹øÄ­
						continue;
					}
					dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1]);
					dp[i][1][j] = Math.max(dp[i - 1][0][j - 1] + 1, dp[i - 1][1][j] + 1);
				}
			}
		}

		int max = 0;
		for (int w = 1; w <= W + 1; w++) {
			max = Math.max(max, dp[T][0][w]);
			max = Math.max(max, dp[T][1][w]);
		}
		System.out.println(max);
	}
}