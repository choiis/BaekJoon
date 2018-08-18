import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1325 {

	private static Scanner sc = null;

	private static int[] computer = null;

	private static boolean[][] connect = null;

	private static int MAX = Integer.MIN_VALUE;

	private static void bfs_cnt(int start) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		int cnt = 1;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < connect[now].length; i++) {
				if (connect[now][i]) {
					queue.add(i);
					cnt++;
				}
			}
		}
		computer[start] = cnt;
		if (MAX < cnt) {
			MAX = cnt;
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1325.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		connect = new boolean[N][N];
		computer = new int[N];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			connect[y - 1][x - 1] = true;
		}

		for (int i = 0; i < N; i++) {
			bfs_cnt(i);
		}

		for (int i = 0; i < computer.length; i++) {
			if (MAX == computer[i]) {
				System.out.print((i + 1) + " ");
			}
		}
	}
}
