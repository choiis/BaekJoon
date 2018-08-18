import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon11066 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon11066.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			int K = sc.nextInt();
			int[][] dp = new int[K + 1][K + 1];
			for (int i = 1; i <= K; i++) {
				dp[i][i] = sc.nextInt();
			}

			for (int i = 2; i <= K; i++) {

				for (int j = 1; j < K - i; j++) {
				
				}
			}

			System.out.println(dp[1][K]);
		}
	}
}