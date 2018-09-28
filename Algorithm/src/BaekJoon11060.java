import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon11060 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon11066.txt"));
		// sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 2; i <= N; i++) {
			dp[i] = 1 + N;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j]) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}

		}

		if (dp[N] != N + 1) {
			System.out.println(dp[N]);
		} else {
			System.out.println("-1");
		}
	}
}