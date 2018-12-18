
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon2668 {

	private static Scanner sc;

	private static int N;
	private static int[] graph;
	private static int[] cycle;
	// 0 �湮 X
	// 1 �湮 �ѹ�
	// 2 �湮 �ι� = >Cycle�̴�

	private static void dfs(int now) {
		if (cycle[now] == 2) {
			return;
		}
		cycle[now]++;
		dfs(graph[now]);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

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

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (cycle[i] == 2) {
				heap.add(i);
			}
		}

		System.out.println(heap.size());
		while (!heap.isEmpty()) {
			System.out.println(heap.poll());
		}
	}
}