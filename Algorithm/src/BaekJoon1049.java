
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1049 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] packs = new int[M];
		int[] strings = new int[M];
		for (int i = 0; i < M; i++) {
			packs[i] = sc.nextInt();
			strings[i] = sc.nextInt();
		}
		Arrays.sort(packs);
		Arrays.sort(strings);

		int div = N / 6;
		int min = (div + 1) * packs[0];
		for (int i = 0; i <= div; i++) {
			int left = N - i * 6;
			min = Math.min(min, i * packs[0] + left * strings[0]);
		}
		System.out.println(min);
	}
}