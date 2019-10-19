import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon11656 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		String str = sc.next();
		int length = str.length();
		String[] strArr = new String[length];

		for (int i = 0; i < length; i++) {
			strArr[i] = str.substring(length - i - 1, length);
		}

		Arrays.sort(strArr);
		for (int i = 0; i < length; i++) {
			System.out.println(strArr[i]);
		}
	}
}