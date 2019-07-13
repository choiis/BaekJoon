import java.util.Scanner;

public class BaekJoon2953 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = 5;
		int M = 4;
		int max = 0;
		int maxIdx = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += sc.nextInt();
			}
			if (sum > max) {
				max = sum;
				maxIdx = i;
			}
		}
		System.out.println(maxIdx + " " + max);
	}
}