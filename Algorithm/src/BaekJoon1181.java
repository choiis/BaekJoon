import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon1181 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon1181.txt"));

		int N = sc.nextInt();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			set.add(str);
		}

		Alpha[] alphas = new Alpha[set.size()];
		Iterator<String> iter = set.iterator();
		int cnt = 0;
		while (iter.hasNext()) {
			String element = iter.next();
			alphas[cnt++] = new Alpha(element);

		}

		Arrays.sort(alphas);

		for (int i = 0; i < alphas.length; i++) {
			System.out.println(alphas[i].alpha);
		}
	}
}

class Alpha implements Comparable<Alpha> {

	String alpha;

	public Alpha() {
	}

	public Alpha(String alpha) {
		this.alpha = alpha;
	}

	@Override
	public int compareTo(Alpha o) {

		if (alpha.length() != o.alpha.length()) {
			return alpha.length() - o.alpha.length();
		} else {
			return alpha.compareTo(o.alpha);
		}
	}

}