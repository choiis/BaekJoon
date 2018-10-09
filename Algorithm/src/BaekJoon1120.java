import java.util.Scanner;

public class BaekJoon1120 {
	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();

		int min = Integer.MAX_VALUE;
		int lenA = A.length();
		int lenB = B.length();
		for (int i = 0; i <= lenB - lenA; i++) {
			int cnt = 0;
			for (int j = 0; j < lenA; j++) {
				if (A.charAt(j) != B.charAt(j + i)) {
					cnt++;
				}
			}
			min = Math.min(cnt, min);
		}

		System.out.println(min);
	}
}