import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BaekJoon1941 {

	private static Scanner sc = null;

	private static int cnt = 0;
	private static char[][] SY = null;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	private static void dfs(int depth, int nowx, int nowy, int numS) {

		if (depth == 7) {
			if (numS >= 4) {
				cnt++;
			}
			return;
		}

		if (SY[nowx][nowy] == 'S') {
			numS++;
		}

		for (int i = 0; i < 4; i++) {
			int nextx = nowx + direct[i][0];
			int nexty = nowy + direct[i][1];
			if (nextx >= 0 && nextx < 5 && nexty >= 0 && nexty < 5) {
				dfs(depth + 1, nextx, nexty, numS);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon1941.txt"));
		SY = new char[5][5];

		for (int i = 0; i < 5; i++) {
			String str = sc.next();
			for (int j = 0; j < 5; j++) {
				SY[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(1, i, j, 0);
			}
		}
		System.out.println(cnt);
	}
}

class Locate {
	int x;
	int y;

	public Locate(int x, int y) {
		this.x = x;
		this.y = y;
	}

}