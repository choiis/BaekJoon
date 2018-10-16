
import java.math.BigInteger;
import java.util.Scanner;

public class BaekJoon1914 {

	private static Scanner sc = null;

	private static int cnt = 0;

	private static void hanoiTower(int N, int from, int by, int to) {

		cnt++;
		if (N == 1) {
			System.out.println(from + " " + to);
		} else {
			hanoiTower(N - 1, from, to, by);
			System.out.println(from + " " + to);
			hanoiTower(N - 1, by, from, to);
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE);
		System.out.println(c);
		if (N <= 20) {
			hanoiTower(N, 1, 2, 3);
		}
	}
}