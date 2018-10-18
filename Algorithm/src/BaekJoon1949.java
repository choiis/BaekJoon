import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1949 {

	private static Scanner sc = null;

	private static int[] arr;

	private static boolean[] visited;

	private static Vector<Vector<Integer>> vec;

	private static long dfs(int idx, boolean select) {
		long cnt = 0;
		visited[idx] = true;
		for (int i = 0; i < vec.get(idx).size(); i++) {
			int next = vec.get(idx).elementAt(i);
			if (visited[next]) {
				continue;
			}
			if (select) { // 우수마을
				cnt += dfs(next, false);
			} else { // 아닐때
				cnt += Math.max(dfs(next, false), arr[next] + dfs(next, true));
			}
		}
		visited[idx] = false;
		return cnt;
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1949.txt"));
		int N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		vec = new Vector<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			Vector<Integer> v = new Vector<>();
			vec.add(v);
		}
		for (int i = 0; i < N - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			vec.get(x - 1).add(y - 1);
			vec.get(y - 1).add(x - 1);
		}

		System.out.println(Math.max(dfs(0, true) + arr[0], dfs(0, false)));
	}
}