
import java.util.Scanner;

public class BaekJoon10159 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x - 1][y - 1] = 1;
			graph[y - 1][x - 1] = -1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || k == i) {
						continue;
					} else {
						if (graph[j][i] == 1 && graph[i][k] == 1) {
							graph[j][k] = 1;
						} else if (graph[j][i] == -1 && graph[i][k] == -1) {
							graph[j][k] = -1;
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 0 && i != j) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}