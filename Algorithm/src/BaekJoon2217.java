import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2217 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] ropes = new int[N];
		for (int i = 0; i < N; i++) {
			ropes[i] = sc.nextInt();
		}
		Arrays.sort(ropes);
		int max = ropes[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			int multi = N - i;
			max = Math.max(max, ropes[i] * multi);
		}
		System.out.println(max);
	}
}