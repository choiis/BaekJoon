import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon5568 {
	private static Scanner sc;

	private static int n;
	private static int k;

	private static Set<String> set;

	private static String[] numbers;

	private static boolean[] visited;

	private static void dfs(int now, int select, String str) {
		if (select == k) {
			set.add(str);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, select + 1, str + numbers[i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		set = new HashSet<>();
		numbers = new String[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			numbers[i] = line;
		}

		dfs(0, 0, "");
		System.out.println(set.size());
	}
}