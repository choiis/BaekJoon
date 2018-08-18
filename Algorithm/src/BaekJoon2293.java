import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2293 {
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

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2293.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] bills = new int[N];
		for (int i = 0; i < bills.length; i++) {
			bills[i] = sc.nextInt();
		}

		System.out.println(pay(M, bills, N));
	}
}
