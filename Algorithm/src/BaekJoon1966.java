import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1966 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1966.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			for (int i = 0; i < N; i++) {

			}
		}
	}
}

class Print implements Comparable<Print> {
	int idx;
	int priority;

	public Print(int idx, int priority) {
		this.idx = idx;
		this.priority = priority;
	}

	@Override
	public int compareTo(Print o) {
		// TODO Auto-generated method stub
		return 0;
	}

}