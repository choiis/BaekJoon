import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1026 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[N - i - 1];
		}
		System.out.println(sum);
	}
}
