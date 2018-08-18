
import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2579 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2579.txt"));

		int N = sc.nextInt();

		int A[] = new int[N + 1];
		int dp[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[i] = A[i];
			} else if (i == 2) {
				dp[i] = A[i] + A[i - 1];
			} else {
				dp[i] = Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i] + A[i - 1]);
			}
		}

		System.out.println(dp[N]);
	}
}