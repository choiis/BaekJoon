
import java.util.Scanner;

public class BaekJoon9466 {

	private static Scanner sc;

	private static int N;
	private static int[] graph;
	private static int[] cycle;
	// 0 �湮 false
	// 1 �湮 �ѹ� 
	// 2 �湮 �ι� => Cycle�̴�

	// ���� �ð� �ʰ�
	private static void dfs(int now) {
		if (cycle[now] == 2) {
			return;
		}
		cycle[now]++;
		dfs(graph[now]);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			graph = new int[N + 1];
			cycle = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				graph[i] = sc.nextInt();
			}

			for (int i = 1; i <= N; i++) {
				if (cycle[i] != 2) {
					dfs(i);
					for (int j = 1; j <= N; j++) {
						if (cycle[j] != 2) {
							cycle[j] = 0; // ��� ���� �ʱ�ȭ
						}
					}
				}
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (cycle[i] != 2) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}