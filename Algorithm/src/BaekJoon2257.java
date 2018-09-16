import java.util.Scanner;
import java.util.Stack;

public class BaekJoon2257 {
	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		String str = sc.nextLine();

		Stack<Character> stack = new Stack<>();
		int value = 0;
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			if (c == '(') {
				sum = 0;
			} else if (c == ')') {

				while (!stack.isEmpty()) {
					char cc = stack.pop();
					if (cc == 'H') {
						sum += 1;
					} else if (cc == 'C') {
						sum += 12;
					} else {
						sum += 16;
					}
				}
				i++;
				if (i >= str.length()) {
					value += sum;
				} else if (str.charAt(i) != ')' && str.charAt(i) != '(') {
					char ccc = str.charAt(i);
					value += (ccc - '0') * sum;
				} else {
					value += sum;
				}
			} else if (c == 'H' || c == 'C' || c == 'O') {
				stack.push(c);
			}
		}
		System.out.println(value);
	}
}
