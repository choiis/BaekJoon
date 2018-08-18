import java.util.Scanner;

public class BaekJoon2661 {

	private static Scanner sc = null;
	private static int[] arr = new int[81];

	private static boolean stop = false;

	private static boolean check(String s) {
		int length = s.length();
		int loop = length / 2;
		int start = length - 1;
		int end = length;

		for (int i = 1; i <= loop; i++) {
			if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		return true;
	}

	private static void dfs(int depth, String s, int N) {
		if (stop) {
			return;
		}

		if (N == depth) {
			stop = true;
			System.out.println(s);
		} else {
			for (int i = 1; i <= 3; i++) {
				if (check(s + i)) {
					dfs(depth + 1, s + i, N);
				}
			}
		}

	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1 ~ 80
		dfs(1, "1", N);

	}
}