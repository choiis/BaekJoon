
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon16236 {

	private static Scanner sc;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static int[][] arr;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N][N];
		int x = 0, y = 0;
		int fishCnt = 0;
		int fishSize = 2;
		int remainFish = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					x = i;
					y = j;
				} else if (arr[i][j] != 0) {
					fishCnt++;
				}
			}
		}
		int timeCnt = 0;
		while (fishCnt != 0) {
			Queue<FishGrid> queue = new LinkedList<>();
			ArrayList<FishGrid> arrayList = new ArrayList<>();
			boolean[][] visited = new boolean[N][N];
			queue.add(new FishGrid(x, y, 0));
			visited[x][y] = true;

			int foundDist = Integer.MAX_VALUE;
			while (!queue.isEmpty()) {
				FishGrid fishGrid = queue.poll();
				int nowX = fishGrid.getX();
				int nowY = fishGrid.getY();
				int nowDist = fishGrid.getDist();
				if (foundDist <= nowDist) {
					continue;
				}
				for (int i = 0; i < direct.length; i++) {
					int nextX = nowX + direct[i][0];
					int nextY = nowY + direct[i][1];
					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
						if (!visited[nextX][nextY]) {
							visited[nextX][nextY] = true;
							if (fishSize > arr[nextX][nextY] && arr[nextX][nextY] > 0) { // 크기 작으면 먹음
								arrayList.add(new FishGrid(nextX, nextY, nowDist + 1));
								foundDist = nowDist + 1;
							}
							if (fishSize >= arr[nextX][nextY]) { // 크기가 같으면 지나갈 순 있다
								queue.add(new FishGrid(nextX, nextY, nowDist + 1));
							}
						}
					}
				}
			}

			if (arrayList.size() > 0) {
				arrayList.sort(new Sort());
				FishGrid fishGrid = arrayList.get(0);
				fishCnt--;
				x = fishGrid.getX();
				y = fishGrid.getY();

				remainFish--;

				arr[x][y] = 0;
				timeCnt += fishGrid.getDist();
				if (remainFish == 0) {
					fishSize++;
					remainFish = fishSize;
				}
			} else {
				break;
			}
		}

		System.out.println(timeCnt);
	}
}

class Sort implements Comparator<FishGrid> {
	public int compare(FishGrid fish1, FishGrid fish2) {
		if (fish1.getX() < fish2.getX()) {
			return -1;
		} else if (fish1.getX() == fish2.getX()) {
			if (fish1.getY() < fish2.getY()) {
				return -1;
			} else if (fish1.getY() == fish2.getY()) {
				return 0;
			}
			return 1;
		} else {
			return 1;
		}
	}
}

class FishGrid {
	private int x;
	private int y;
	private int dist;

	public FishGrid() {
		super();
	}

	public FishGrid(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
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

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

}