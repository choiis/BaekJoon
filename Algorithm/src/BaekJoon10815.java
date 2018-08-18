import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon10815 {

	private static Scanner sc = null;

	private static boolean binary_search(int left, int right, int number, int[] array) {
		int mid = (left + right) / 2;
		if (left > right) {
			return false;
		} else {
			if (array[mid] > number) {
				return binary_search(left, mid - 1, number, array);
			} else if (array[mid] < number) {
				return binary_search(mid + 1, right, number, array);
			} else {
				return true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon10815.txt"));

		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}
		Arrays.sort(arr1);
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			if (binary_search(0, N - 1, x, arr1)) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}
		}
	}
}