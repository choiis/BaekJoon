import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class BaekJoon2210 {

	private static Scanner sc = null;

	private static int[][] numbers = new int[5][5];

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	private static HashSet<String> hset = new HashSet<>();

	private static void dfs(int x, int y, String str, int depth) {

		if (depth == 5) {
			hset.add(str);
			return;
		}

		for (int i = 0; i < direct.length; i++) {
			int nextX = x + direct[i][0];
			int nextY = y + direct[i][1];
			if (nextX < 5 && nextY < 5 && nextX >= 0 && nextY >= 0) {
				dfs(nextX, nextY, str + Integer.toString(numbers[nextX][nextY]), depth + 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon2210.txt"));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, Integer.toString(numbers[i][j]), 0);
			}
		}
		System.out.println(hset.size());
	}
}