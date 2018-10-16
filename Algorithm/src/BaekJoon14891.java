import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon14891 {

	private static Scanner sc;

	private static void rotate(char[] gear, int direct) {
		if (direct == 1) { // 시계방향
			char tmp = gear[7];
			for (int i = 7; i > 0; i--) {
				gear[i] = gear[i - 1];
			}
			gear[0] = tmp;
		} else { // 반시계방향
			char tmp = gear[0];
			for (int i = 1; i < 8; i++) {
				gear[i - 1] = gear[i];
			}
			gear[7] = tmp;
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon14891.txt"));
		char[][] gear = new char[5][8];
		for (int i = 1; i <= 4; i++) {
			String str = sc.next();
			gear[i] = str.toCharArray();
		}

		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int idx = sc.nextInt();
			int rotate = sc.nextInt();
			int[] arr = new int[5];
			arr[idx] = rotate;
			int left = idx;
			int leftRotate = rotate;
			int right = idx;
			int rightRotate = rotate;
			while (left > 1) {
				if (gear[left][6] == gear[left - 1][2]) {
					break;
				}
				leftRotate *= -1;
				arr[left - 1] = leftRotate;
				left--;
			}

			while (right < 4) {
				if (gear[right][2] == gear[right + 1][6]) {
					break;
				}
				rightRotate *= -1;
				arr[right + 1] = rightRotate;
				right++;
			}
			for (int j = 1; j <= 4; j++) {
				if (arr[j] != 0) {
					rotate(gear[j], arr[j]);
				}
			}
		}

		int cnt = 0;
		if (gear[1][0] == '1') {
			cnt += 1;
		}
		if (gear[2][0] == '1') {
			cnt += 2;
		}
		if (gear[3][0] == '1') {
			cnt += 4;
		}
		if (gear[4][0] == '1') {
			cnt += 8;
		}
		System.out.println(cnt);
	}
}