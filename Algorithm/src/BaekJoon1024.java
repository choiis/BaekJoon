import java.util.Scanner;

public class BaekJoon1024 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int x = 0;
		boolean flag = false;
		while (true) {
			if (((N - L * (L - 1) / 2) % L == 0) && (0 <= (N - L * (L - 1) / 2) / L)) {
				x = (N - L * (L - 1) / 2) / L;
				break;
			} else {
				L++;
			}
			if (L > 100) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			for (int i = x; i < L + x; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("-1");
		}
	}
}