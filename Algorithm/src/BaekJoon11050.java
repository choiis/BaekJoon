import java.util.Scanner;

public class BaekJoon11050 {

	private static Scanner sc = null;

	private static long[][] C;

	private static long comb(int N, int K) {

		if (K == 0 || N == K) {
			return C[N][K] = 1;
		} else {
			return C[N][K] = comb(N - 1, K - 1) + comb(N - 1, K);
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();

		C = new long[N + 1][K + 1];
		System.out.println(comb(N, K));
	}
}