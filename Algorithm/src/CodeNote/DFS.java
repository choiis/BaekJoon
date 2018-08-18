package CodeNote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFS {

	private static Scanner sc = null;

	private static boolean[][] edge = null;
	private static boolean[] visited = null;

	private static void dfs(int now) {
		visited[now] = true;
		System.out.print(now + 1 + " ");
		for (int i = 0; i < edge.length; i++) {
			if (!visited[i] && edge[now][i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		sc = new Scanner(new FileInputStream("dfs.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();

		edge = new boolean[N][N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			edge[x - 1][y - 1] = true;
		}
		dfs(0);
	}
}