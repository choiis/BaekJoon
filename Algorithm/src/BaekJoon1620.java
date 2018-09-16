import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BaekJoon1620 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon1620.txt"));
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] list = new String[N + 1];
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			list[i] = str;
			hashMap.put(str, i);
		}

		for (int i = 1; i <= M; i++) {
			String str = sc.next();
			try {
				System.out.println(list[Integer.parseInt(str)]);
			} catch (NumberFormatException e) {
				System.out.println(hashMap.get(str));
			}
		}
	}
}
