
import java.util.Scanner;

public class BaekJoon1965 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] box = new int[N];
		for (int i = 0; i < N; i++) {
			box[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		dp[0] = 1;
		int max = dp[0];
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				// if (box[i] > box[j]) {
				// dp[i] = Math.max(dp[i], dp[j] + 1);
				// break;
				// }
				if (box[i] > box[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}