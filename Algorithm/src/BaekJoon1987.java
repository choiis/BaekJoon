import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class BaekJoon1987 {

	private static Scanner sc = null;

	private static HashSet<Character> hashSet = null;

	private static char[][] board = null;

	private static int MAX = 0;
	private static int R;
	private static int C;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static void dfs(int x, int y, int cnt) {

		if (hashSet.contains(board[x][y])) {
			return;
		} else {
			MAX = Math.max(MAX, cnt);
			hashSet.add(board[x][y]);
			for (int i = 0; i < direct.length; i++) {
				int nextX = x + direct[i][0];
				int nextY = y + direct[i][1];
				if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
					if(!hashSet.contains(board[nextX][nextY])) {
						dfs(nextX, nextY, cnt + 1);	
					}
				}
			}
			hashSet.remove(board[x][y]);
		}
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1987.txt"));

		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			board[i] = str.toCharArray();
		}
		hashSet = new HashSet<>();
		dfs(0, 0, 1);
		System.out.println(MAX);
	}
}