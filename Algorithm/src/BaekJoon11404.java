import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon11404 {
	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon11404.txt"));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (graph[x - 1][y - 1] != 0) {
				graph[x - 1][y - 1] = Math.min(z, graph[x - 1][y - 1]);
			} else {
				graph[x - 1][y - 1] = z;
			}

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || k == i) {
						continue;
					} else {
						if (graph[j][i] != 0 && graph[i][k] != 0) {
							if (graph[j][k] != 0) {
								graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
							} else {
								graph[j][k] = graph[j][i] + graph[i][k];
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}