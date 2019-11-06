import java.util.Scanner;
import java.util.Stack;

public class BaekJoon4889 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = 1;
		while (true) {

			char[] str = sc.next().toCharArray();
			if (str[0] == '-') {
				break;
			}
			int cnt = 0;
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length; i++) {
				if (stack.isEmpty() && str[i] == '}') {
					cnt++;
					str[i] = '{';
					stack.push(str[i]);
				} else if (!stack.isEmpty() && str[i] == '}') {
					stack.pop();
				} else {
					stack.push(str[i]);
				}

			}
			cnt += stack.size() / 2;
			System.out.println(t + ". " + cnt);
			t++;
		}
	}
}