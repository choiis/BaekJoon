import java.util.Scanner;

public class BaekJoon11401 {

	private static final long DIV = 1000000007;
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		long[] fac = new long[N + 1];
		fac[0] = 1;
		fac[1] = 1;

		for (int i = 2; i <= N; i++)
			fac[i] = (fac[i - 1] * i) % DIV;

		long n = (fac[K] * fac[N - K]) % DIV;

		long index = DIV - 2;
		long fermatNum = 1;
		while (index > 0) {
			if (index % 2 == 1) {
				fermatNum *= n;
				fermatNum %= DIV;
			}
			n = (n * n) % DIV;
			index /= 2;
		}
		long result = ((fac[N] % DIV) * (fermatNum % DIV)) % DIV;
		System.out.print(result);

	}
}