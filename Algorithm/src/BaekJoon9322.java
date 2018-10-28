
import java.util.Scanner;

public class BaekJoon9322 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			String[][] encode = new String[2][N];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					encode[i][j] = sc.next();
				}
			}
			int[] index = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (encode[0][i].equals(encode[1][j])) {
						index[j] = i;
					}
				}
			}
			String[] ciphers = new String[N];
			for (int i = 0; i < N; i++) {
				ciphers[i] = sc.next();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (index[j] == i) {
						System.out.print(ciphers[j] + " ");
					}
				}
			}
			System.out.println();
		}
	}
}