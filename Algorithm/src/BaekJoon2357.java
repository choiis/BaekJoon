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

		ArrayList<Integer> v = new ArrayList<Integer>(N + 1);

		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			v.add(t);
		}

		segmentTree1.insert(v);
		segmentTree2.insert(v);

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(segmentTree1.getMin(x, y) + " " + segmentTree2.getMax(x, y));
		}
	}

}

class MinSegmetTree {
	ArrayList<Integer> tree;
	int s;

	public MinSegmetTree(int n) {
		s = 1;
		while (s < n) {
			s *= 2;
		}

		tree = new ArrayList<Integer>(s * 2);
		tree.add(0);
		for (int i = 1; i < s + s; i++)
			tree.add(Integer.MAX_VALUE);
	}

	void insert(ArrayList<Integer> d) {
		for (int i = s; i < s + d.size(); i++) {
			tree.set(i, d.get(i - s));
		}
		for (int i = s - 1; i >= 1; i--)
			tree.set(i, Integer.min(tree.get(i * 2), tree.get(i * 2 + 1)));
	}

	int getMin(int Left, int Right) {
		int l = Left + s - 1, r = Right + s - 1;
		int rval = Integer.MAX_VALUE;
		while (l <= r) {
			if (l % 2 == 0)
				l /= 2;
			else {
				rval = Integer.min(rval, tree.get(l));
				l = (l / 2) + 1;
			}
			if (r % 2 == 1)
				r /= 2;
			else {
				rval = Integer.min(rval, tree.get(r));
				r = (r / 2) - 1;
			}
		}
		return rval;
	}

}

class MaxSegmentTree {
	ArrayList<Integer> tree;
	int s;

	public MaxSegmentTree(int n) {
		s = 1;
		while (s < n) {
			s *= 2;
		}

		tree = new ArrayList<Integer>(s * 2);
		tree.add(0);
		for (int i = 1; i < s + s; i++)
			tree.add(Integer.MIN_VALUE);
	}

	void insert(ArrayList<Integer> d) {
		for (int i = s; i < s + d.size(); i++) {
			tree.set(i, d.get(i - s));
		}
		for (int i = s - 1; i >= 1; i--)
			tree.set(i, Integer.max(tree.get(i * 2), tree.get(i * 2 + 1)));
	}

	int getMax(int Left, int Right) {
		int l = Left + s - 1, r = Right + s - 1;
		int rval = Integer.MIN_VALUE;
		while (l <= r) {
			if (l % 2 == 0)
				l /= 2;
			else {
				rval = Integer.max(rval, tree.get(l));
				l = (l / 2) + 1;
			}
			if (r % 2 == 1)
				r /= 2;
			else {
				rval = Integer.max(rval, tree.get(r));
				r = (r / 2) - 1;
			}
		}
		return rval;
	}
}
