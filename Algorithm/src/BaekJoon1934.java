import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1934 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1934.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int gcd = gcd(Math.min(A, B), Math.max(A, B));
			System.out.println((A * B) / gcd);
		}
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}