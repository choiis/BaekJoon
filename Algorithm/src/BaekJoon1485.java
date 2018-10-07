import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1485 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1485.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			XY[] arr = new XY[4];
			for (int i = 0; i < 4; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new XY(x, y);
			}
			Arrays.sort(arr);

			int d1 = dist(arr[0].x, arr[0].y, arr[1].x, arr[1].y);
			int d2 = dist(arr[0].x, arr[0].y, arr[2].x, arr[2].y);
			int d3 = dist(arr[2].x, arr[2].y, arr[3].x, arr[3].y);
			int d4 = dist(arr[3].x, arr[3].y, arr[1].x, arr[1].y);

			if (d1 == d2 && d2 == d3 && d3 == d4) {
				boolean a1 = ((arr[0].y - arr[2].y) * (arr[0].y - arr[1].y) == (arr[2].x - arr[0].x)
						* (arr[0].x - arr[1].x));
				boolean a2 = ((arr[3].y - arr[1].y) * (arr[1].y - arr[0].y) == (arr[1].x - arr[3].x)
						* (arr[1].x - arr[0].x));
				boolean a3 = ((arr[3].y - arr[2].y) * (arr[3].y - arr[1].y) == (arr[2].x - arr[3].x)
						* (arr[3].x - arr[1].x));
				boolean a4 = ((arr[3].y - arr[2].y) * (arr[2].y - arr[0].y) == (arr[2].x - arr[3].x)
						* (arr[2].x - arr[0].x));

				if (a1 && a2 && a3 && a4) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else {
				System.out.println("0");
			}
		}
	}

	private static int dist(int x1, int y1, int x2, int y2) {

		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}

class XY implements Comparable<XY> {
	int x;
	int y;

	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(XY o) {
		if (this.x == o.x) {
			return o.y - this.y;
		} else {
			return o.x - this.x;
		}
	}

}