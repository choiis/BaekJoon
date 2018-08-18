import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Nodes {
	char data;
	Nodes left, right;

	public Nodes(char data) {
		this.data = data;
	}
}

class Tree {

	Nodes root;

	public void add(char data, char left, char right) {
		if (root == null) {

			if (data != '.')
				root = new Nodes(data);

			if (left != '.')
				root = new Nodes(left);

			if (right != '.')
				root = new Nodes(right);
		} else {
			search(root, data, left, right);
		}
	}

	private void search(Nodes root, char data, char left, char right) {

		if (root == null)
			return;
		else if (root.data == data) {
			if (left != '.')
				root.left = new Nodes(left);
			if (right != '.')
				root.right = new Nodes(right);
		} else {
			search(root.left, data, left, right);

			search(root.right, data, left, right);
		}
	}

	public void preorder(Nodes root) {
		System.out.println(root.data);
		if (root.left != null)
			preorder(root.left);
		if (root.right != null)
			preorder(root.right);
	}

	public void inorder(Nodes root) {

		if (root.left != null)
			inorder(root.left);
		System.out.println(root.data);
		if (root.right != null)
			inorder(root.right);
	}

	public void postorder(Nodes root) {

		if (root.left != null)
			postorder(root.left);
		if (root.right != null)
			postorder(root.right);
		System.out.println(root.data);
	}
}

public class BaekJoon1991 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("baekjoon1991.txt")));

		int N = Integer.parseInt(in.readLine());
		Tree tree = new Tree();
		for (int i = 0; i < N; i++) {
			char[] data = in.readLine().replaceAll("", "").toCharArray();

			tree.add(data[0], data[1], data[2]);
		}

		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
	}
}