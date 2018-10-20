import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon15686 {

	private static Scanner sc;

	private static List<House> chickenlist;
	private static List<House> houseList;

	private static boolean[] chichkenSelect;

	private static int N;
	private static int M;

	private static int[][] grid;

	private static int min = Integer.MAX_VALUE;

	private static void dfs(int depth, boolean[] select, int startIdx) {
		if (depth == M) {
			int sum = 0;
			for (int i = 0; i < houseList.size(); i++) {

				House house = houseList.get(i);
				int houseX = house.x;
				int houseY = house.y;
				int chickenDist = Integer.MAX_VALUE;
				for (int j = 0; j < chickenlist.size(); j++) {
					if (chichkenSelect[j]) {
						int chickenX = chickenlist.get(j).x;
						int chickenY = chickenlist.get(j).y;
						int tmpDist = Math.abs(chickenX - houseX) + Math.abs(chickenY - houseY);
						chickenDist = Math.min(tmpDist, chickenDist);
					}
				}
				sum += chickenDist;
			}
			min = Math.min(sum, min);
			return;
		} else {
			for (int i = startIdx; i < chickenlist.size(); i++) {
				if (select[i]) {
					continue;
				}
				select[i] = true;
				dfs(depth + 1, select, startIdx + 1);
				select[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon15686.txt"));
		chickenlist = new ArrayList<>();
		houseList = new ArrayList<>();
		N = sc.nextInt();
		M = sc.nextInt();
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
				if (grid[i][j] == 2) {
					chickenlist.add(new House(i, j));
				} else if (grid[i][j] == 1) {
					houseList.add(new House(i, j));
				}
			}
		}

		chichkenSelect = new boolean[chickenlist.size()];
		dfs(0, chichkenSelect, 0);
		System.out.println(min);
	}
}

class House {
	int x;
	int y;

	public House(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}