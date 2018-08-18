import java.util.Scanner;

public class BaekJoon9663 {

	private static Scanner sc;
	private static int N;
	private static int[] arr;
	private static boolean[] dx;
	private static boolean[] dy;

	private static int result;

	private static void dfs(int depth) {
		if (depth == N) {
			result++;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] == 1) || dx[depth + i] || dy[N - 1 + (depth - i)])
				continue;

			arr[i] = 1;
			dx[depth + i] = dy[N - 1 + (depth - i)] = true;
			dfs(depth + 1);
			arr[i] = 0;
			dx[depth + i] = dy[N - 1 + (depth - i)] = false;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N];
		dx = new boolean[2 * N + 1];
		dy = new boolean[2 * N + 1];
		dfs(0);
		System.out.println(result);
	}
}