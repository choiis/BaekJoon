
import java.util.Scanner;

public class BaekJoon1551 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String[] str = sc.next().split(",");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				arr[j] = arr[j + 1] - arr[j];
			}
		}
		for (int i = 0; i < N - K; i++) {
			if (i != N - K - 1) {
				System.out.print(arr[i] + ",");
			} else {
				System.out.print(arr[i]);
			}

		}
	}
}