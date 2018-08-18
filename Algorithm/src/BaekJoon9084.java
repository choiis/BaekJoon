import java.util.Scanner;

public class BaekJoon9084 {
	private static Scanner sc = null;

	private static int pay(int money, int[] bills, int k) {

		int cnt = 0;

		if (k == 1) {
			if (money % bills[0] == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		int t = money / bills[k - 1];
		for (int i = 0; i <= t; i++) {
			cnt += pay(money - bills[k - 1] * i, bills, k - 1);
		}
		return cnt;
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int sum = sc.nextInt();
			System.out.println(pay(sum, arr, N));
		}
	}
}
