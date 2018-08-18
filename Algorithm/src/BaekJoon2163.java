import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon2163 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon2163.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		System.out.println(N * M - 1);
	}
}