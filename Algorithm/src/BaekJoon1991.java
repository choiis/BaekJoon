
import java.util.Scanner;

public class BaekJoon1991 {
	private static Scanner sc = null;

	private static int[][] tree = new int[26][2];

	private static void preOrder(int node) {
		if (node == (int) ('.' - 'A')) {
			return;
		}
		System.out.print((char) (node + 'A'));
		preOrder(tree[node][0]);
		preOrder(tree[node][1]);
	}

	private static void inOrder(int node) {
		if (node == (int) ('.' - 'A')) {
			return;
		}
		inOrder(tree[node][0]);
		System.out.print((char) (node + 'A'));
		inOrder(tree[node][1]);
	}

	private static void postOrder(int node) {
		if (node == (int) ('.' - 'A')) {
			return;

		}
		postOrder(tree[node][0]);
		postOrder(tree[node][1]);
		System.out.print((char) (node + 'A'));
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		int N = sc.nextInt();

		String str = sc.nextLine();
		for (int i = 0; i < N; i++) {
			char[] data = sc.nextLine().replaceAll(" ", "").toCharArray();
			tree[data[0] - 'A'][0] = data[1] - 'A';
			tree[data[0] - 'A'][1] = data[2] - 'A';
		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}
}