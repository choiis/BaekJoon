import java.util.Scanner;

public class BaekJoon10808 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String str = sc.next();
		int[] alpha = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - '0' - 49]++;
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i] + " ");
		}

	}
}