import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1759 {

	private static Scanner sc = null;
	private static char[] arr = null;

	private static PriorityQueue<String> heap = new PriorityQueue<>();

	private static void print_arr(char[] set, int size) {
		String str = "";
		for (int i = 0; i < size; i++) {
			str = str + set[i];
		}
		heap.add(str);
	}

	private static void comb(char[] set, int size, int n, int k, int idx) {
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

		sc = new Scanner(new FileInputStream("baekjoon1759.txt"));

		int K = sc.nextInt();
		int N = sc.nextInt();
		arr = new char[N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			arr[i] = str.toCharArray()[0];
		}
		char[] set = new char[N];
		comb(set, 0, N, K, 0);

		for (int i = 0; i < heap.size(); i++) {
			System.out.println(heap.poll());
		}
	}

}
