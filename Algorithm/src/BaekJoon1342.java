
import java.util.Scanner;

public class BaekJoon1342 {
	private static Scanner sc = null;

	private static char[] arr;

	private static int cnt = 0;

	private static int N;

	private static void dfs(int idx, int depth, int now, char[] set, boolean[] selected) {

		if (depth == N) {
			cnt++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (depth == 0) {
					if (!selected[i]) {
						set[depth] = arr[i];
						selected[i] = true;
						dfs(idx + 1, depth + 1, i, set, selected);
						selected[i] = false;
					}
				} else {
					if (set[depth - 1] != arr[i]) {
						if (!selected[i]) {
							set[depth] = arr[i];
							selected[i] = true;
							dfs(idx + 1, depth + 1, i, set, selected);
							selected[i] = false;
						}
					}
				}
			}
		}
	}

	private static int fac(int n) {

		int cnt = 1;
		for (int i = n; 1 <= i; i--) {
			cnt *= i;
		}

		return cnt;
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		String str = sc.next();
		N = str.length();
		arr = str.toCharArray();

		int[] alphabet = new int[26];

		for (int i = 0; i < arr.length; i++) {
			alphabet[arr[i] - 'a']++;
		}

		char[] set = new char[N];
		boolean[] selected = new boolean[N];
		dfs(0, 0, -1, set, selected);

		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > 1) {
				cnt /= fac(alphabet[i]);
			}
		}
		System.out.println(cnt);
	}

}
