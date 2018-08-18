import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2740 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2740.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] a = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		M = sc.nextInt();
		int K = sc.nextInt();
		int[][] b = new int[M][K];
		for (int j = 0; j < M; j++) {
			for (int k = 0; k < K; k++) {
				b[j][k] = sc.nextInt();
			}
		}

		int[][] c = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < K; k++) {
				for (int j = 0; j < M; j++) {
					c[i][k] += a[i][j] * b[j][k];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}