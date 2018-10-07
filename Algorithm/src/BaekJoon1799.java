import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1799 {
	private static Scanner sc = null;

	private static int N;
	private static int[][] chess;

	private static int max_black = 0;
	private static int max_white = 0;

	private static boolean can(int x1, int y1, int x2, int y2) {

		int dx = x1 - x2;
		int dy = y1 - y2;

		if (dx == dy || dx == -dy) {
			return false;
		} else {
			return true;
		}
	}

	private static void dfs_black(int start, int cnt, ArrayList<Bishop> bishops) {
		max_black = Math.max(max_black, cnt);

		for (int k = start; k < N * N; k += 2) {
			int i = k / N;
			int j = k % N;
			if (chess[i][j] != 1) {
				continue;
			}
			boolean go = true;
			for (int a = 0; a < bishops.size(); a++) {
				if (!can(i, j, bishops.get(a).getX(), bishops.get(a).getY())) {
					go = false;
					break;
				}
			}

			if (go) {
				bishops.add(new Bishop(i, j));
				dfs_black(k, cnt + 1, bishops);
				int size = bishops.size();
				bishops.remove(size - 1);
			}
			dfs_black(k + 2, cnt, bishops);
		}
	}

	private static void dfs_white(int start, int cnt, ArrayList<Bishop> bishops) {
		max_white = Math.max(max_white, cnt);

		for (int k = start; k < N * N; k += 2) {
			int i = k / N;
			int j = k % N;
			if (chess[i][j] != 1) {
				continue;
			}
			boolean go = true;
			for (int a = 0; a < bishops.size(); a++) {
				if (!can(i, j, bishops.get(a).getX(), bishops.get(a).getY())) {
					go = false;
					break;
				}
			}

			if (go) {
				bishops.add(new Bishop(i, j));
				dfs_white(k, cnt + 1, bishops);
				int size = bishops.size();
				bishops.remove(size - 1);
			}
			dfs_white(k + 2, cnt, bishops);
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chess[i][j] = sc.nextInt();
			}
		}
		ArrayList<Bishop> list1 = new ArrayList<>();
		dfs_black(0, 0, list1);
		ArrayList<Bishop> list2 = new ArrayList<>();
		dfs_white(1, 0, list2);
		System.out.println(max_black + max_white);
	}
}

class Bishop {

	private int x;
	private int y;

	public Bishop() {

	}

	public Bishop(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}