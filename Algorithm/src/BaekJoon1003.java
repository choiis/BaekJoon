import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1003 {

	private static Scanner sc = null;

	private static int[] dp = null;

	private static int fibo(int n) {
		if (dp[n] != 0) {
			return dp[n];
		} else if (n <= 1) {
			return dp[n] = 1;
		} else {
			return dp[n] = fibo(n - 1) + fibo(n - 2);
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1003.txt"));

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int M = sc.nextInt();
			dp = new int[M + 1];
			if (M == 0) {
				System.out.println("1 0");
			} else if (M == 1) {
				System.out.println("0 1");
			} else {
				fibo(M);
				System.out.println(dp[M - 2] + " " + dp[M - 1]);
			}

		}
	}

}