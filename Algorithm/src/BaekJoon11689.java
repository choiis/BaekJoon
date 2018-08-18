import java.util.Scanner;

public class BaekJoon11689 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		long N = sc.nextLong();
		int cnt = 0;
		for (long k = 1; k <= N; k++) {
			if (checkGcd(k, N)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static boolean checkGcd(long k, long n) {

		while (n != 0) {
			long t = k % n;
			k = n;
			n = t;
		}

		return k == 1;
	}

}