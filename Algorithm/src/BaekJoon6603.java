import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon6603 {

	private static Scanner sc = null;
	private static int[] arr = null;

	private static void print_arr(int[] set, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(set[i] + " ");
		}
		System.out.println();
	}

	private static void comb(int[] set, int size, int n, int k, int idx) {
		if (k == 0) {
			print_arr(set, size);
			return;
		} else if (idx == n) {
			return;
		} else {
			set[size] = arr[idx];
			comb(set, size + 1, n, k - 1, idx + 1);
			comb(set, size, n, k, idx + 1);
		}
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon6603.txt"));

		while (true) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int[] set = new int[6];
			comb(set, 0, N, 6, 0);
			System.out.println();
		}
	}

}
