
import java.util.Scanner;

public class BaekJoon13241 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();

		long gcd = gcd(A, B);
		System.out.println((A * B) / gcd);
	}

	private static long gcd(long A, long B) {
		while (B != 0) {
			long temp = A % B;
			A = B;
			B = temp;
		}
		return A;
	}
}