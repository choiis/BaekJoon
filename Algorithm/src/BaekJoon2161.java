import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekJoon2161 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Deque<Integer> card = new LinkedList<>();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			card.add(i);
		}
		ArrayList<Integer> arrayList = new ArrayList<>();
		int cnt = 0;
		while (card.size() > 1) {
			if (cnt % 2 == 0) {
				arrayList.add(card.pollFirst());
			} else {
				card.add(card.pollFirst());
			}
			cnt++;
		}

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println(card.getFirst());
	}
}