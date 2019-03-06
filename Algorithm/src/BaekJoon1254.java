import java.util.Scanner;

public class BaekJoon1254 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String str = sc.next();
		for (int i = str.length();; i++) {
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				if ((i - j - 1) < str.length() && str.charAt(j) != str.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(i);
				break;
			}
		}
	}
}