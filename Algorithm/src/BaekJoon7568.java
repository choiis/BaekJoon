import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon7568 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon7568.txt"));
		int N = sc.nextInt();

		D[] arr = new D[N];
		for (int i = 0; i < N; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			arr[i] = new D(w, h);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (i == j)
					continue;

				if ((arr[i].height < arr[j].height) && (arr[i].weight < arr[j].weight)) {
					arr[i].rank++;
				}

				if ((arr[j].height < arr[i].height) && (arr[j].weight < arr[i].weight)) {
					arr[j].rank++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i].rank);
		}
	}
}

class D {
	int weight;
	int height;
	int rank;

	public D(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
		this.rank = 1;
	}

}