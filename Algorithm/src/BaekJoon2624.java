import java.util.Scanner;

public class BaekJoon2624 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int K = sc.nextInt();
		int[][] coin = new int[K][2];
		for (int i = 0; i < K; i++) {
			coin[i][0] = sc.nextInt();
			coin[i][1] = sc.nextInt();
		}
		int[] cntCase = new int[T + 1];
		for (int i = 0; i < K; i++) {
			for (int j = 1; j <= coin[i][1]; j++) {
				if (coin[i][0] * j <= T) {
					cntCase[coin[i][0] * j]++;
				}
			}
		}
		for (int i = 0; i < cntCase.length; i++) {
			System.out.print(cntCase[i] + " ");
		}
	}
}