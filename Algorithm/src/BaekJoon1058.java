import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1058 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1058.txt"));

		int N = sc.nextInt();
		String[] friends = new String[N];
		for (int i = 0; i < N; i++) {
			friends[i] = sc.next();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (friends[i].charAt(j) == 'Y') {
					cnt++;
				} else {
					for (int k = 0; k < N; k++) {
						if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
							cnt++;
							break;
						}
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
