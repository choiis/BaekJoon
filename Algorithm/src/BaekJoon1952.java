import java.util.Scanner;

public class BaekJoon1952 {

	private static Scanner sc;

	private static int[][] direct = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static int curve(int now) {
		now++;
		if (now >= direct.length) {
			return 0;
		} else {
			return now;
		}
	}

	// 우 하 좌 상 순서
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[][] visited = new boolean[M][N];
		int curveCnt = 0;
		int visitedCnt = 1;
		int direction = 0; // 우
		int x = 0, y = 0;
		visited[x][y] = true;
		while (visitedCnt != M * N) {
			int nextX = x + direct[direction][0];
			int nextY = y + direct[direction][1];
			if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) { // 범위벗어남
				direction = curve(direction);
				curveCnt++;
				continue;
			} else if (visited[nextX][nextY]) {
				direction = curve(direction);
				curveCnt++;
				continue;
			} else {
				x = nextX;
				y = nextY;
				visited[x][y] = true;
				visitedCnt++;
			}
		}
		System.out.println(curveCnt);
	}
}