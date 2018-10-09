import java.util.Scanner;

public class BaekJoon2294 {
	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[101];
		int[] dp = new int[10001];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > K) {
				continue;
			}
			dp[arr[i]] = 1;
		}

		for (int i = 0; i <= K; i++) {
			if (dp[i] != 0) {
				continue;
			}
			dp[i] = K + 1;
			for (int j = 0; j < N; j++) {
				if (i - arr[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
				}
			}
		}
		if (dp[K] == K + 1) {
			System.out.println("-1");
		} else {
			System.out.println(dp[K]);
		}

	}
}