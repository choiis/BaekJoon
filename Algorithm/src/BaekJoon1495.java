import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1495 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1495.txt"));
		int N = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int[] V = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			V[i] = sc.nextInt();
		}
		int[][] dp = new int[N + 1][M + 1];
		dp[0][S] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i - 1][j] == 1) {
					if (j + V[i] <= M) {
						dp[i][j + V[i]] = 1;
					}
					if (j - V[i] >= 0) {
						dp[i][j - V[i]] = 1;
					}
				}
			}
		}
		boolean flag = false;
		int cnt = 0;
		for (int i = M; i >= 0; i--) {
			if (dp[N][i] == 1) {
				flag = true;
				cnt = i;
				break;
			}
		}

		if (flag) {
			System.out.println(cnt);
		} else {
			System.out.println("-1");
		}
	}
}
