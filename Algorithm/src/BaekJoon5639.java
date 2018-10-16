import java.util.Scanner;

public class BaekJoon5639 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String num = sc.nextLine();
		TreeNode treeNode = new TreeNode(Integer.parseInt(num));
		while (sc.hasNextLine()) {
			num = sc.nextLine();
			if ("".equals(num)) {
				break;
			} else {
				treeNode = binaryInsert(treeNode, Integer.parseInt(num));
			}
		}

		postOrder(treeNode);
	}

	private static TreeNode binaryInsert(TreeNode node, int val) {
		if (node == null) {
			return new TreeNode(val);
		} else if (node.getNum() > val) {
			node.left = binaryInsert(node.left, val);
		} else if (node.getNum() < val) {
			node.right = binaryInsert(node.right, val);
		}
		return node;
	}

	private static void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.getNum());
		}
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	private int num;

	public TreeNode(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}