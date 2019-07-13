import java.util.Scanner;

public class BaekJoon2846 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 0;
		int ans = 0;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				ans += (arr[i + 1] - arr[i]);
			} else {
				ans = 0;
			}
			max = Math.max(ans, max);
		}
		System.out.println(max);
	}
}