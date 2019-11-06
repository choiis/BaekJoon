import java.util.Scanner;

public class BaekJoon1864 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		while (true) {
			String str = sc.next();
			if ("#".equals(str)) {
				break;
			}
			int number = 0;
			int power = 1;
			for (int i = str.length() - 1; i >= 0; i--) {
				number += power * getInt(str.charAt(i));
				power *= 8;
			}
			System.out.println(number);
		}
	}

	private static int getInt(char c) {
		switch (c) {
		case '-':
			return 0;
		case '\\':
			return 1;
		case '(':
			return 2;
		case '@':
			return 3;
		case '?':
			return 4;
		case '>':
			return 5;
		case '&':
			return 6;
		case '%':
			return 7;
		default:
			return -1;
		}
	}
}
