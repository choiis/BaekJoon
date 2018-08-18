import java.util.Scanner;

public class BaekJoon2023 {

	private static boolean isPrime(int p) {
		if (p == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int from = 1;
		for (int i = 0; i < N - 1; i++) {
			from *= 10;
		}

		int to = 10 * from;
		for (int i = from; i < to; i++) {
			boolean flag = true;
			int div = to;
			for (int j = 0; j <= N; j++) {
				if (!isPrime(i / div)) {
					flag = false;
					break;
				}
				div /= 10;
			}

			if (flag) {
				System.out.println(i);
			}
		}
	}
}