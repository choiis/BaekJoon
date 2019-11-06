import java.util.Scanner;

public class BaekJoon3943 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int max = N;
			while (N != 1) {
				N = (N % 2 == 0) ? (N / 2) : (3 * N + 1);
				max = Math.max(max, N);
			}
			System.out.println(max);
		}
	}
}