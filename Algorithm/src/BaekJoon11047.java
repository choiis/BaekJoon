import java.util.Scanner;

public class BaekJoon11047 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			int c = K / coins[i];
			if (c == 0) {
				continue;
			}
			cnt += c;
			K %= coins[i];
		}
		System.out.println(cnt);
	}
}