
import java.util.Scanner;

public class BaekJoon1316 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 0;
		for (int t = 0; t < T; t++) {
			String str = sc.next();
			boolean[] alpha = new boolean[26];
			alpha[(str.charAt(0) - 'a')] = true;
			boolean group = true;
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) == str.charAt(i - 1)) {
					continue;
				} else {
					if (alpha[(str.charAt(i) - 'a')]) {
						group = false;
						break;
					} else {
						alpha[(str.charAt(i) - 'a')] = true;
					}
				}
			}
			if (group) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}