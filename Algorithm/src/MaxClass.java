import java.io.FileInputStream;
import java.util.Scanner;

public class MaxClass {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("maxClass.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] point = new int[N];
		int i;
		for (i = 0; i < N; i++) {
			point[i] = sc.nextInt();
		}

	}
}