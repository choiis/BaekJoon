import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon7469 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon7469.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();

		Number[] arr = new Number[N];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			arr[i] = new Number(x, i + 1);
		}

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			int K = sc.nextInt();

			int cnt = 0;
			for (int j = 0; j < N; j++) {

				if (arr[j].getIdx() >= I && arr[j].getIdx() <= J) {
					cnt++;
				}

				if (cnt == K) {
					System.out.println(arr[j].getNumber());
					break;
				}

			}

		}
	}
}

class Number implements Comparable<Number> {

	private int number;
	private int idx;

	public Number() {
	}

	public Number(int number, int idx) {
		this.number = number;
		this.idx = idx;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public int compareTo(Number o) {
		if (number < o.getNumber())
			return -1;
		else if (number == o.getNumber())
			return 0;
		else
			return 1;
	}
}