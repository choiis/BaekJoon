import java.util.Scanner;

public class BaekJoon10448 {

	private static Scanner sc;
	private static int N;
	private static int[] T;

	private static boolean isEureka(int K) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (T[i] + T[j] + T[k] == K) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		N = 1;
		int i = 1;
		while (true) {
			if (i * (i + 1) <= 2000) {
				i++;
			} else {
				N = --i;
				break;
			}
		}
		T = new int[N];
		for (int j = 1; j <= N; j++) {
			T[j - 1] = j * (j + 1) / 2;
		}
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int j = 0; j < t; j++) {
			int K = sc.nextInt();
			if (isEureka(K)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}