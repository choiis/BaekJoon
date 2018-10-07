
import java.util.Scanner;

public class BaekJoon2875 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		for (int i = M; i > 0; i--) {
			if (2 * i > N) {
				continue;
			}
			int left = M - i;
			left += N - 2 * i;
			if (left >= K) {
				cnt = i;
				break;
			}
		}
		System.out.println(cnt);
	}
}