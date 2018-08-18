import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon10942 {
	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon10942.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			System.out.println(isPalindrome(arr, from, to));
		}
	}

	private static int isPalindrome(int[] arr, int from, int to) {

		int mid = (from + to) / 2;
		for (int i = from; i <= mid; i++) {
			if (arr[i] != arr[to + from - i]) {
				return 0;
			}
		}

		return 1;
	}
}
