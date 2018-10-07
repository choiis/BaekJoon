import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon11399 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] times = new int[N];
		for (int i = 0; i < N; i++) {
			times[i] = sc.nextInt();
		}
		Arrays.sort(times);
		int cnt = 0;
		for (int i = 0; i < times.length; i++) {
			int sum = 0;
			for (int j = i; j >= 0; j--) {
				sum += times[j];
			}
			cnt += sum;
		}

		System.out.println(cnt);
	}
}