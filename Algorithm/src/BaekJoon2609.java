import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2609 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int gcd = gcd(Math.min(N, M), Math.max(N, M));
		System.out.println(gcd);
		System.out.println((N * M) / gcd);
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
