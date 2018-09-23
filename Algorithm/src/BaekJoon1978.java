import java.util.Scanner;

public class BaekJoon1978 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] p = new int[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
			if (isPrime(p[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static boolean isPrime(int P) {

		if (P == 1) {
			return false;
		}

		for (int i = 2; i * i <= P; i++) {
			if (P % i == 0) {
				return false;
			}
		}

		return true;
	}
}