import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon11722 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon11722.txt"));
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
