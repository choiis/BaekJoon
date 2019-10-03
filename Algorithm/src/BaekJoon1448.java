import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1448 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = N - 1; i >= 2; i--) {
			if (arr[i] < arr[i - 1] + arr[i - 2]) {
				System.out.println(arr[i] + arr[i - 1] + arr[i - 2]);
				return;
			}
		}

		System.out.println("-1");
	}
}