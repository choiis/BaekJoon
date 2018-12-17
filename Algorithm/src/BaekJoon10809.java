import java.util.Scanner;

public class BaekJoon10809 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String str = sc.next();
		int[] alpha = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1 };
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - '0' - 49;
			if (alpha[idx] == -1) {
				alpha[idx] = i;
			}
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i] + " ");
		}

	}
}