import java.io.FileInputStream;

import java.util.Scanner;

public class BaekJoon6591 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon6591.txt"));

		while (true) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			if (N == 0 && M == 0) {
				break;
			} else {

				if (N - M < N)
					M = N - M;

				long comb = 1;
				for (long i = 1; i <= M; i++) {
					comb *= N - i + 1;
					comb /= i;
				}

				System.out.println(comb);
			}
		}
	}
}