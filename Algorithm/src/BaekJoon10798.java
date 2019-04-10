import java.util.Scanner;

public class BaekJoon10798 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String[] strs = new String[5];
		int maxLength = 0;
		for (int i = 0; i < 5; i++) {
			strs[i] = sc.next();
			maxLength = Math.max(maxLength, strs[i].length());
		}

		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < 5; j++) {
				if (i < strs[j].length()) {
					System.out.print(strs[j].charAt(i));
				}
			}
		}
	}
}