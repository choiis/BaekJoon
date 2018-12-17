import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon3047 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		String str;
		str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			System.out.print(arr[(str.charAt(i) - 'A')] + " ");
		}
	}
}