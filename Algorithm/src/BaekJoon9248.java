import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon9248 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon9248.txt"));
		String text = sc.nextLine();
		int length = text.length();
		Suffix[] array = new Suffix[length];
		for (int i = 0; i < length; i++) {
			array[i] = new Suffix(text.substring(i), i + 1);
		}

		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i].idx + " ");
		}
		System.out.println();
		System.out.print("x ");
		for (int i = 1; i < array.length; i++) {
			int len = Math.min(array[i - 1].text.length(), array[i].text.length());
			int cnt = 0;
			for (int j = 0; j < len; j++) {
				if (array[i - 1].text.charAt(j) == array[i].text.charAt(j)) {
					cnt++;
				} else {
					break;
				}
			}
			System.out.print(cnt + " ");
		}
	}

}

class Suffix implements Comparable<Suffix> {

	String text;
	int idx;

	public Suffix() {

	}

	public Suffix(String text, int idx) {
		this.text = text;
		this.idx = idx;
	}

	@Override
	public int compareTo(Suffix o) {
		return text.compareTo(o.text);
	}

}