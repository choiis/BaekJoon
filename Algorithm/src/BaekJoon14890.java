
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon14890 {

	private static Scanner sc;

	private static int N;
	private static int L;
	private static int[][] board;

	private static boolean passHorizen(int x) {
		int nowHeight = board[x][0];
		int arrL = 1;
		for (int i = 1; i < N; i++) {
			if (Math.abs(nowHeight - board[x][i]) == 2) {
				return false;
			} else if (nowHeight == board[x][i]) {
				arrL++;
			} else if (nowHeight - board[x][i] == 1) { // 다음 높이가 낮을 때
				if (N < i + L) {
					return false;
				}
				int tmpHeight = board[x][i];
				for (int j = i + 1; j < i + L; j++) {
					if (tmpHeight != board[x][j]) {
						return false;
					}
				}
				arrL = 0;
				i = i + L - 1;
				nowHeight = tmpHeight;
				continue;
			} else if (nowHeight - board[x][i] == -1) { // 다음 높이가 높을 때
				if (arrL < L) { // 블럭 놓을 수 없음
					return false;
				}
				nowHeight = board[x][i];
				arrL = 1;
			}

		}

		return true;
	}

	private static boolean passVertical(int x) {
		int nowHeight = board[0][x];
		int arrL = 1;
		for (int i = 1; i < N; i++) {
			if (Math.abs(nowHeight - board[i][x]) == 2) {
				return false;
			} else if (nowHeight == board[i][x]) {
				arrL++;
			} else if (nowHeight - board[i][x] == 1) { // 다음 높이가 낮을 때
				if (N < i + L) {
					return false;
				}
				int tmpHeight = board[i][x];
				for (int j = i + 1; j < i + L; j++) {
					if (tmpHeight != board[j][x]) {
						return false;
					}
				}
				arrL = 0;
				i = i + L - 1;
				nowHeight = tmpHeight;
				continue;
			} else if (nowHeight - board[i][x] == -1) { // 다음 높이가 높을 때
				if (arrL < L) { // 블럭 놓을 수 없음
					return false;
				}
				nowHeight = board[i][x];
				arrL = 1;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon14890.txt"));
		N = sc.nextInt();
		L = sc.nextInt();
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (passHorizen(i)) {
				cnt++;
			}
		}
		for (int i = 0; i < N; i++) {
			if (passVertical(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}