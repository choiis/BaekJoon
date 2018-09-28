import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon7785 {
	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon7785.txt"));

		int N = sc.nextInt();
		HashMap<String, String> hashMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str1 = sc.next();
			String str2 = sc.next();

			if ("enter".equals(str2)) {
				hashMap.put(str1, "value");
			} else if ("leave".equals(str2)) {
				hashMap.remove(str1);
			}
		}

		Set<String> set = hashMap.keySet();
		String[] names = new String[set.size()];
		Iterator<String> it = set.iterator();
		int idx = 0;
		while (it.hasNext()) {
			names[idx] = it.next();
			idx++;
		}

		Arrays.sort(names);
		for (int i = names.length - 1; i >= 0; i--) {
			System.out.println(names[i]);
		}
	}
}
