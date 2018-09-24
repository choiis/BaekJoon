import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1759 {

	private static Scanner sc = null;
	private static int N;
	private static int K;
	private static char[] arr = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1759.txt"));

		K = sc.nextInt();
		N = sc.nextInt();
		arr = new char[N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			arr[i] = str.charAt(0);
		}
		Arrays.sort(arr);

		char[] set = new char[K];
		dfs(0, 0, -1, set);
	}

	private static void dfs(int idx, int depth, int now, char[] set) {

		if (depth == K) {
			if (min3(set)) {
				print(set);
			}
			return;
		} else {
			for (int i = now + 1; i < Math.min(idx + K, N); i++) {
				set[depth] = arr[i];
				dfs(idx + 1, depth + 1, i, set);
			}
		}
	}

	private static boolean min3(char[] set) {

		int mo = 0;
		int ja = 0;
		for (int i = 0; i < K; i++) {
			if (set[i] == 'a' || set[i] == 'e' || set[i] == 'i' || set[i] == 'o' || set[i] == 'u') {
				mo++;
			} else {
				ja++;
			}
		}

		return (mo >= 1) && (ja >= 2);
	}

	private static void print(char[] set) {
		for (int i = 0; i < set.length; i++) {
			System.out.print(set[i]);
		}
		System.out.println();
	}

}
