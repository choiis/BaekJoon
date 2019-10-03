import java.util.Scanner;

public class BaekJoon10773 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack stack = new Stack(N);
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				stack.pop();
			} else {
				stack.push(x);
			}
		}
		int num = 0;
		while (!stack.isEmpty()) {
			num += stack.pop();
		}
		System.out.println(num);
	}
}

class Stack {
	private int idx = 0;
	private int[] arr;

	public Stack(int size) {
		arr = new int[size];
	}

	public boolean isEmpty() {
		return (idx > 0) ? false : true;
	}

	public int size() {
		return idx;
	}

	public void push(int num) {
		arr[idx++] = num;
	}

	public int pop() {
		idx--;
		int result = arr[idx];
		arr[idx] = 0;
		return result;
	}
}