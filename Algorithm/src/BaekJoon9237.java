import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon9237 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			arr[i] += (N - i);
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max + 1);
	}
}