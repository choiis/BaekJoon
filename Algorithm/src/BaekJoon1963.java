
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1963 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			boolean[] visited = new boolean[10000];
			Queue<PNumber> queue = new LinkedList<>();
			queue.add(new PNumber(num1, 0));
			visited[num1] = true;
			int[] numPosition = new int[4];
			boolean can = false;
			int cnt = 0;
			while (!queue.isEmpty()) {
				PNumber pn = queue.poll();
				int nowNumber = pn.getNumber();
				int nowCnt = pn.getCnt();
				if (nowNumber == num2) {
					can = true;
					cnt = nowCnt;
					break;
				}
				for (int i = 0; i < 4; i++) {
					numPosition[0] = nowNumber / 1000;
					numPosition[1] = (nowNumber % 1000) / 100;
					numPosition[2] = (nowNumber % 100) / 10;
					numPosition[3] = nowNumber % 10;
					for (int j = 0; j < 10; j++) {
						if (numPosition[i] == j) {
							continue;
						} else if (i == 0 && j == 0) {
							continue;
						} else {
							numPosition[i] = j;
							int nextNum = 1000 * numPosition[0] + 100 * numPosition[1] + 10 * numPosition[2]
									+ numPosition[3];
							if (isPrime(nextNum) && !visited[nextNum]) {
								queue.add(new PNumber(nextNum, nowCnt + 1));
								visited[nextNum] = true;
							}
						}
					}
				}
			}
			if (can) {
				System.out.println(cnt);
			} else {
				System.out.println("Impossible");
			}
		}
	}

	private static boolean isPrime(int num) {
		try {
			if (num == 1) {
				return false;
			}
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					return false;
				}
			}
		} catch (NumberFormatException e) {

		}

		return true;
	}
}

class PNumber {
	private int number;
	private int cnt;

	public PNumber() {
		super();
	}

	public PNumber(int number, int cnt) {
		super();
		this.number = number;
		this.cnt = cnt;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}