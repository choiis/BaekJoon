import java.util.Scanner;

public class BaekJoon10872 {

	private static Scanner sc = null;

	private static long facto(int K) {

		if (K == 1) {
			return 1;
		} else {
			return K * facto(K - 1);
		}

	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.println(facto(N));
	}
}