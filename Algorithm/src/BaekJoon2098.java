import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2098 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2098.txt"));

		int N = sc.nextInt();

		int[][] weight = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				weight[i][j] = sc.nextInt();
			}
		}
		
	}
}
