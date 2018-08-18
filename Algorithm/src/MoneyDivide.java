import java.io.FileInputStream;
import java.util.Scanner;

public class MoneyDivide {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("C:/JavaEx/Algorithm/input3.txt"));

		int t = sc.nextInt();
		for (int T = 1; T <= t; T++) {

			int N = sc.nextInt();
			int[] bills = new int[N];
			for (int i = 0; i < N; i++) {
				bills[i] = sc.nextInt();
			}
			int money = sc.nextInt();

			int answer = money_count(N, bills, money);

			System.out.println("테스트 케이스 : " + T);
			System.out.println("답 : " + answer);
		}
	}

	private static int money_count(int now, int[] bills, int money) {

		int cnt = 0;
		if (now == 1) {
			if ((money % bills[0]) == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		int T = money / bills[now - 1];
		for (int i = 0; i <= T; i++) {
			cnt += money_count(now - 1, bills, money - i * bills[now - 1]);
		}

		return cnt;
	}
}
