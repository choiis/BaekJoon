import java.util.Scanner;

public class BaekJoon1068 {
	private static Scanner sc;

	private static int N;
	private static boolean[][] graph;

	private static int leaf = 0;

	private static void dfs(int from) {

		boolean isLeaf = true;
		for (int i = 0; i < N; i++) {
			if (graph[from][i]) {
				isLeaf = false;
				dfs(i);
			}
		}
		if (isLeaf) {
			leaf++;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		int root = -1;
		graph = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == -1) {
				root = i;
			} else {
				graph[x][i] = true;
			}
		}
		int delete = sc.nextInt();
		for (int i = 0; i < N; i++) {
			graph[i][delete] = false;
		}
		dfs(root);

		System.out.println(leaf);
	}
}
