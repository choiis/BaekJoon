import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon9012 {

	private static Scanner sc = null;

	private static boolean check(String str) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon9012.txt"));

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String line = sc.next();
			if (check(line)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}