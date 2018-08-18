import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon11048 {
	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon11048.txt"));

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] arr = new int[N + 1][K + 1];
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = Math.max(Math.max(dp[i - 1][j] + arr[i][j], dp[i][j - 1] + arr[i][j]),
						dp[i - 1][j - 1] + arr[i][j]);
			}
		}
		System.out.println(dp[N][K]);
	}

}
