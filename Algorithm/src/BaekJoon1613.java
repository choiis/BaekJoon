import java.util.Scanner;

public class BaekJoon1613 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] relation = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			relation[x][y] = -1;
			relation[y][x] = 1;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j || j == k || k == i) {
						continue;
					} else if (relation[i][j] == 0) {
						if (relation[i][k] == -1 && relation[k][j] == -1)
							relation[i][j] = -1;
						else if (relation[i][k] == 1 && relation[k][j] == 1)
							relation[i][j] = 1;
					}
				}
			}
		}
		int s = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sb.append(relation[x][y] + "\n");
		}
		System.out.println(sb);
	}
}