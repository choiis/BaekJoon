import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon3187 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] field = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			field[i] = line.toCharArray();
		}
		boolean[][] check = new boolean[N][M];

		int totalSheep = 0;
		int totalWolf = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j] && field[i][j] != '#') {
					int sheep = 0;
					int wolf = 0;

					Queue<FieldAnimal> queue = new LinkedList<FieldAnimal>();
					queue.add(new FieldAnimal(i, j));
					check[i][j] = true;
					if (field[i][j] == 'k') {
						sheep++;
					} else if (field[i][j] == 'v') {
						wolf++;
					}

					while (!queue.isEmpty()) {
						FieldAnimal fieldAnimal = queue.poll();
						int x = fieldAnimal.getX();
						int y = fieldAnimal.getY();

						for (int k = 0; k < direct.length; k++) {
							int nextX = x + direct[k][0];
							int nextY = y + direct[k][1];

							if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
								if (field[nextX][nextY] != '#' && !check[nextX][nextY]) {
									check[nextX][nextY] = true;
									queue.add(new FieldAnimal(nextX, nextY));
									if (field[nextX][nextY] == 'k') {
										sheep++;
									} else if (field[nextX][nextY] == 'v') {
										wolf++;
									}
								}
							}
						}
					}
					// ºÎºÐ Å½»ö ³¡
					if (wolf < sheep) {
						wolf = 0;
					} else {
						sheep = 0;
					}
					totalSheep += sheep;
					totalWolf += wolf;
				}
			}
		}
		System.out.println(totalSheep + " " + totalWolf);
	}

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}

class FieldAnimal {
	private int x;
	private int y;

	public FieldAnimal() {
		super();
	}

	public FieldAnimal(int x, int y) {
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