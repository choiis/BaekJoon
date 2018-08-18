import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2750 {

	private static Scanner sc = null;

	private static void insert(int[] arr, int last) {
		int i, tmp;

		tmp = arr[last];
		for (i = last; i > 0 && arr[i - 1] > tmp; i--) {
			arr[i] = arr[i - 1];
		}
		arr[i] = tmp;
	}

	private static void insertion_sort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			insert(arr, i);
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2750.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		insertion_sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}