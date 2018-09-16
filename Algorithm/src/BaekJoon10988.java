import java.util.Scanner;

public class BaekJoon10988 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		String str = sc.nextLine();
		int len = str.length();

		boolean flag = true;

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) == str.charAt(len - 1 - i)) {
				continue;
			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}
}