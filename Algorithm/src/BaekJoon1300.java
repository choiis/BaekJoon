

import java.util.Scanner;

public class BaekJoon1300 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		long N = sc.nextInt();
		long K = sc.nextInt();
		long left = 1;
		long right = K;
		long ans = 0;
		while (left <= right) {
			long cnt = 0;
			long mid = (left + right) / 2;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			if (cnt < K) {
				left = mid + 1;
			} else {
				ans = mid;
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
}