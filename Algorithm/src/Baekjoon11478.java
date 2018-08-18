import java.util.Scanner;

public class Baekjoon11478 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		String text = sc.nextLine();
		int length = text.length();

		int count = 0;

		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				String cover = text.substring(i + 1);
				String sub = text.substring(i, j + 1);
				if (cover.contains(sub)) {
					continue;
				} else {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
