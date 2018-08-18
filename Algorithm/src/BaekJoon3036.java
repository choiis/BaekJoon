import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon3036 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon3036.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++) {
			ring(arr[0], arr[i]);
		}
	}

	private static void ring(int x, int y) {

		int gcd = gcd(x, y);
		System.out.println(x / gcd + "/" + y / gcd);
	}

	private static int gcd(int a, int b) {
		int A = Math.max(a, b);
		int B = Math.min(a, b);

		while (A != 0) {
			int t = B % A;
			B = A;
			A = t;
		}
		return B;
	}
}