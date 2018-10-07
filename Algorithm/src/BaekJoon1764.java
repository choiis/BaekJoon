import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon1764 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1764.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			set.add(str);
		}
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			if (set.contains(str)) {
				list.add(str);
			}
		}

		String[] array = list.toArray(new String[list.size()]);
		Arrays.sort(array);
		System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}