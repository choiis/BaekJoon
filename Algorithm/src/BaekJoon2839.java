import java.util.Scanner;

public class BaekJoon2839 {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int x = 3;
		int y = 5;
		int result = -1;
		for (int i = 0; i <= N / x; i++) {
			for (int j = 0; j <= N / y; j++) {
				if (i * x + y * j == N) {
					if (result == -1) {
						result = i + j;
					} else {
						result = Math.min(result, i + j);
					}
				}
			}
		}
		System.out.println(result);
	}
}