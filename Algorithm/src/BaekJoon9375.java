import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon9375 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon9375.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			HashMap<String, Integer> hashMap = new HashMap<>();

			for (int i = 0; i < N; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				if (hashMap.containsKey(s2)) {
					int idx = hashMap.get(s2);
					hashMap.put(s2, idx + 1);
				} else {
					hashMap.put(s2, 1);
				}
			}

			Iterator<String> iterator = hashMap.keySet().iterator();
			int cnt = 1;
			while (iterator.hasNext()) {
				cnt *= (hashMap.get(iterator.next()) + 1);
			}
			System.out.println(cnt - 1);
		}
	}
}