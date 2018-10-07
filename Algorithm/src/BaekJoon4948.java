import java.util.Scanner;

public class BaekJoon4948 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}
			int cnt = 0;
			for (int i = num + 1; i <= 2 * num; i++) {
				if (isPrime(i)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	private static boolean isPrime(int P) {

		if (P == 1) {
			return false;
		}

		for (int i = 2; i * i <= P; i++) {
			if (P % i == 0) {
				return false;
			}
		}

		return true;
	}

}
