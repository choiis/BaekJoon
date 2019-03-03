import java.util.Scanner;

public class BaekJoon2042 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		SegmentTree segmentTree = new SegmentTree(arr);
		for (int i = 0; i < M + K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 1) {
				segmentTree.change(b, c);
			} else {
				System.out.println(segmentTree.query(1, 0, N - 1, b - 1, c - 1));
			}
		}
	}
}

class SegmentTree {
	private int[] treeArr;
	private long[] treeNode;
	private int N;

	public SegmentTree(int[] treeArr) {
		super();
		N = treeArr.length;
		this.treeArr = treeArr;
		int H = (int) Math.pow(2.0, Math.floor((Math.log(N) / Math.log(2.0)) + 1));
		treeNode = new long[2 * H];
		initTree(1, 0, N - 1);
	}

	public void change(int b, int c) {
		long diff = c - treeArr[--b];
		treeArr[b] = c;
		update(1, 0, N - 1, b, diff);
	}

	private long initTree(int idx, int start, int end) {
		if (start == end) {
			return treeNode[idx] = treeArr[start];
		} else {
			return treeNode[idx] = initTree(2 * idx, start, (start + end) / 2)
					+ initTree(2 * idx + 1, (start + end) / 2 + 1, end);
		}
	}

	public long query(int idx, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		} else if (left <= start && right >= end) {
			return treeNode[idx];
		} else {
			return query(2 * idx, start, (start + end) / 2, left, right)
					+ query(2 * idx + 1, (start + end) / 2 + 1, end, left, right);
		}
	}

	private void update(int idx, int start, int end, int change, long diff) {
		if (change < start || change > end) {
			return;
		}
		treeNode[idx] = treeNode[idx] + diff;
		if (start != end) {
			update(idx * 2, start, (start + end) / 2, change, diff);
			update(idx * 2 + 1, (start + end) / 2 + 1, end, change, diff);
		}
	}
}