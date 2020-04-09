import java.util.Scanner;

public class BaekJoon1065 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		if (N < 100) {
			System.out.println(N);
		} else {

			int three = 0;
			int ten = 0;
			int one = 0;
			int cnt = 0;
			for (int i = 100; i <= N; i++) {
				three = i / 100;
				ten = (i % 100) / 10;
				one = i % 10;
				if ((three - ten) == (ten - one)) {
					cnt++;
				}
			}
			System.out.println(99 + cnt);
		}
	}
}