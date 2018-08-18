import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2902 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2902.txt"));

		String line = sc.nextLine();
		String[] str = line.split("-");
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i].charAt(0));
		}
	}
}