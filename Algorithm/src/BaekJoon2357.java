import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon2357 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		MinSegmetTree segmentTree1 = new MinSegmetTree(N);
		MaxSegmentTree segmentTree2 = new MaxSegmentTree(N);

		int[] treeArr = new int[N + 1];

		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			treeArr[i] = t;
		}

		segmentTree1.insert(treeArr);
		segmentTree2.insert(treeArr);

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(segmentTree1.getMin(x, y) + " " + segmentTree2.getMax(x, y));
		}
	}

}

class MinSegmetTree {
	int[] tree;
	int s;

	public MinSegmetTree(int n) {
		s = 1;
		while (s < n) {
			s *= 2;
		}

		tree = new int[s * 2];
		for (int i = 1; i < 2 * s; i++) {
			tree[i] = Integer.MAX_VALUE;
		}
	}

	void insert(int[] arr) {
		for (int i = s; i < s + arr.length; i++) {
			tree[i] = arr[i - s];
		}
		for (int i = s - 1; i >= 1; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
	}

	int getMin(int left, int right) {
		int l = left + s - 1, r = right + s - 1;
		int rval = Integer.MAX_VALUE;
		while (l <= r) {
			if (l % 2 == 0)
				l /= 2;
			else {
				rval = Math.min(rval, tree[l]);
				l = (l / 2) + 1;
			}
			if (r % 2 == 1)
				r /= 2;
			else {
				rval = Math.min(rval, tree[r]);
				r = (r / 2) - 1;
			}
		}
		return rval;
	}

}

class MaxSegmentTree {
	int[] tree;
	int s;

	public MaxSegmentTree(int n) {
		s = 1;
		while (s < n) {
			s *= 2;
		}

		tree = new int[s * 2];
		for (int i = 1; i < s * 2; i++) {
			tree[i] = Integer.MIN_VALUE;
		}
	}

	void insert(int[] arr) {
		for (int i = s; i < s + arr.length; i++) {
			tree[i] = arr[i - s];
		}
		for (int i = s - 1; i >= 1; i--)
			tree[i] = Math.max(tree[i * 2], tree[i * 2 + 1]);
	}

	int getMax(int left, int right) {
		int l = left + s - 1, r = right + s - 1;
		int rval = Integer.MIN_VALUE;
		while (l <= r) {
			if (l % 2 == 0)
				l /= 2;
			else {
				rval = Math.max(rval, tree[l]);
				l = (l / 2) + 1;
			}
			if (r % 2 == 1)
				r /= 2;
			else {
				rval = Math.max(rval, tree[r]);
				r = (r / 2) - 1;
			}
		}
		return rval;
	}
}
