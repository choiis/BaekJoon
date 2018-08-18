
import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2577 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2577.txt"));

		long X = sc.nextInt();
		long Y = sc.nextInt();
		long Z = sc.nextInt();

		long result = X * Y * Z;
		String str = Long.toString(result);
		for (int i = 0; i <= 9; i++) {
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) - '0' == i) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}