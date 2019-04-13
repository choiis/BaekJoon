import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon2252 {

	private static int n;
	private static int m;
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		Vector<Vector<Integer>> vec = new Vector<>();
		for (int i = 0; i <= n; i++) {
			vec.add(new Vector<>());
		}
		int ind[] = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			vec.get(u).add(v);
			ind[v]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (ind[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int now = q.remove();
			System.out.print(String.valueOf(now) + ' ');
			for (int i = 0; i < vec.get(now).size(); i++) {
				int next = vec.get(now).get(i);
				ind[next]--;
				if (ind[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}
