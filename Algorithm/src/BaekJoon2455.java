import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2455 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {
		sc = new Scanner(new FileInputStream("baekjoon2455.txt"));

		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int now = cnt - a;
			now += b;
			cnt = Math.max(cnt, now);
		}
		System.out.println(cnt);
	}
}