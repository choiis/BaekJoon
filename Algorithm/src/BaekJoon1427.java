import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1427 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1427.txt"));

		String line = sc.next();
		int[] arr = new int[line.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = line.charAt(i) - '0';
		}

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}