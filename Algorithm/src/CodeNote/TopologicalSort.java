package CodeNote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
	static int n;
	static int m;
	static int s;
	private static Scanner sc;

	public static void main(String args[]) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("topological.txt"));

		n = sc.nextInt();
		m = sc.nextInt();

		ArrayList<Integer>[] adj_list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj_list[i] = new ArrayList<>();
		}

		int ind[] = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj_list[u].add(v);
			ind[v]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (ind[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int here = q.remove();
			System.out.print(String.valueOf(here) + ' ');
			for (int i = 0; i < adj_list[here].size(); i++) {
				int there = adj_list[here].get(i);
				ind[there]--;
				if (ind[there] == 0) {
					q.add(there);
				}
			}
		}
	}
}
