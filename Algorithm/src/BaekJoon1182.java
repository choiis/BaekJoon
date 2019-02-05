
import java.util.Scanner;

public class BaekJoon1182 {

	private static Scanner sc;

	private static int N;
	private static int S;
	private static int[] arr;
	private static int cnt = 0;

	private static void dfs(int idx, int sum) {
		sum += arr[idx];
		if (sum == S) {
			cnt++;
		}
		for (int i = idx + 1; i < N; i++) {
			dfs(i, sum);
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
}