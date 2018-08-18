import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1300 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1300.txt"));
		int N = sc.nextInt();

		int[] B = new int[N * N];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				B[cnt++] = i * j;
			}
		}

		Arrays.sort(B);
		int K = sc.nextInt();
		System.out.println(B[K - 1]);
	}
}