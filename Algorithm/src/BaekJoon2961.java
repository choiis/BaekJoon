import java.util.Scanner;

public class BaekJoon2961 {

	private static Scanner sc;

	private static int N;

	private static int[] S;
	private static int[] B;

	private static int min = Integer.MAX_VALUE;

	private static void dfs(int idx, int depth, boolean[] selected) {

		if (depth == N) {
			int sumS = 1;
			int sumB = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sumS *= S[i];
					sumB += B[i];
				}
			}
			int diff = Math.abs(sumB - sumS);
			min = Math.min(diff, min);

			return;
		} else {
			for (int i = idx; i < N; i++) {
				if (!selected[i]) {
					selected[i] = true;
					dfs(i + 1, depth + 1, selected);
					selected[i] = false;
					dfs(i + 1, depth + 1, selected);
				}
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		boolean[] selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		dfs(0, 0, selected);
		System.out.println(min);
	}
}