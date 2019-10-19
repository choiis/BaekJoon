import java.util.Scanner;

public class BaekJoon2617 {
	private static Scanner sc;

	private static int N;
	private static int M;

	private static int[][] weight;

	private static int[] more;
	private static int[] less;

	private static boolean[] visited;

	private static void dfsMore(int start, int now) {
		visited[now - 1] = true;

		for (int i = 0; i < M; i++) {
			if (now == weight[i][1] && !visited[weight[i][0] - 1]) {
				more[start - 1]++;
				dfsMore(start, weight[i][0]);
			}
		}
	}

	private static void dfsLess(int start, int now) {
		visited[now - 1] = true;

		for (int i = 0; i < M; i++) {
			if (now == weight[i][0] && !visited[weight[i][1] - 1]) {
				less[start - 1]++;
				dfsLess(start, weight[i][1]);
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 0번이 1번보다 무겁다
		weight = new int[M][2];
		more = new int[N];
		less = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			weight[i][0] = sc.nextInt();
			weight[i][1] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			dfsLess(i, i);
			for (int j = 0; j < N; j++) {
				visited[j] = false;
			}
			dfsMore(i, i);
			for (int j = 0; j < N; j++) {
				visited[j] = false;
			}
		}
		int cnt = 0;
		int half = (N + 1) / 2;
		for (int i = 0; i < N; i++) {
			if (more[i] >= half || less[i] >= half) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}