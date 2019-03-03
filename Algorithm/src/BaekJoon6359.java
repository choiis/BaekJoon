import java.util.Scanner;

public class BaekJoon6359 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			boolean[] jail = new boolean[N + 1];
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= N; j++) {
					if (j % i == 0) {
						if (jail[j]) {
							jail[j] = false;
							cnt--;
						} else {
							jail[j] = true;
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}