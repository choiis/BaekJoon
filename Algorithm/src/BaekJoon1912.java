import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1912 {
	private static Scanner sc = null;

	private static int[] dp = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1912.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		cal_max_sum(arr);
		System.out.println(find_max_sum(arr, N));
	}

	private static void cal_max_sum(int[] arr) {

		int i;

		dp[0] = arr[0];
		for (i = 1; i < arr.length; i++) {
			dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
		}
	}

	private static int find_max_sum(int[] arr, int n) {

		if (n == 1) {
			return arr[0];
		} else {
			return Math.max(dp[n - 1], find_max_sum(arr, n - 1));
		}
	}
}