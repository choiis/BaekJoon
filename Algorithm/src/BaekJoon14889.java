
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon14889 {

	private static Scanner sc;

	private static int N;
	private static int[][] arr;

	private static boolean[] selected;

	private static int min = Integer.MAX_VALUE;

	private static void dfs(int idx, int cnt) {
		if (cnt == N / 2) {
			int otherSum1 = 0;
			int otherSum2 = 0;
			for (int i = 0; i < N; i++) {
				if (!selected[i]) {
					for (int j = 0; j < N; j++) {
						if (!selected[j] && i != j) {
							otherSum1 += arr[i][j];
							otherSum1 += arr[j][i];
						}
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (selected[j] && i != j) {
							otherSum2 += arr[i][j];
							otherSum2 += arr[j][i];
						}
					}
				}
			}
			min = Math.min(min, Math.abs(otherSum2 - otherSum1) / 2);

			return;
		}

		for (int i = idx; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				dfs(i + 1, cnt + 1);
				selected[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon14889.txt"));
		N = sc.nextInt();
		arr = new int[N][N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);
		System.out.println(min);
	}
}