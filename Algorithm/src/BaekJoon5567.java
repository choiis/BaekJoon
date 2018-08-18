import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon5567 {

	private static Scanner sc = null;

	private static int bfs(int start, boolean[][] friends, boolean[] visited, int N) {

		Queue<F_Relation> queue = new LinkedList<>();
		queue.add(new F_Relation(start, 0));
		visited[start] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			F_Relation relation = queue.poll();
			int f = relation.f;
			if (relation.depth >= 2) {
				continue;
			}
			for (int i = 0; i < N; i++) {
				if (!visited[i] && friends[f][i]) {
					cnt++;
					visited[i] = true;
					queue.add(new F_Relation(i, relation.depth + 1));
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon5567.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] friends = new boolean[N][N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			friends[x - 1][y - 1] = true;
			friends[y - 1][x - 1] = true;
		}

		System.out.println(bfs(0, friends, visited, N));
	}
}

class F_Relation {
	int f;
	int depth;

	public F_Relation() {

	}

	public F_Relation(int f, int depth) {
		this.f = f;
		this.depth = depth;
	}

}
