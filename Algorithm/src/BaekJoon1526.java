
import java.util.Scanner;

public class BaekJoon1526 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i;
		for (i = N; i > 0; i--) {
			String str = Integer.toString(i);
			if (check(str)) {
				break;
			}
		}

		System.out.println(i);
	}

	private static boolean check(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '7' && str.charAt(i) != '4') {
				return false;
			}
		}
		return true;
	}
}