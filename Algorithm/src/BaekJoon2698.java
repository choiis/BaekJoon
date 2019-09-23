import java.util.Scanner;

public class BaekJoon2698 {
	private static Scanner sc;

	// [n][m][k] => ���̰� n, ������Ʈ m, �������ڸ� k
	private static int[][][] dp = new int[101][100][2];

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();

		dp[1][0][1] = 1;
		dp[1][0][0] = 1;

		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j < i; j++) { // ������Ʈ�� ũ�� i���� �Ѱ��۾���
				if (j == 0) {
					dp[i][j][1] = dp[i - 1][j][0];
				} else {
					dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
				}
				dp[i][j][0] = dp[i - 1][j][1] + dp[i - 1][j][0];
			}
		}

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(dp[N][M][0] + dp[N][M][1]);
		}
	}
}