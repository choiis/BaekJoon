import java.util.Scanner;

public class BaekJoon3079 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] T = new int[N];

		int max = 0;
		for (int i = 0; i < T.length; i++) {
			T[i] = sc.nextInt();
			max = Math.max(max, T[i]);
		}
		long left = 0;
		long right = max * M;
		long cnt = Integer.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < T.length; i++) {
				sum += mid / T[i];
			}

			if (sum < M) {
				left = mid + 1;
			} else {
				if (cnt > mid) {
					cnt = mid;
				} else {
					right = mid - 1;
				}
			}
		}
		System.out.println(cnt);
	}
}