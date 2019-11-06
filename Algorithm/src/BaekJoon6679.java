
public class BaekJoon6679 {

	public static void main(String[] args) {

		for (int i = 1000; i < 10000; i++) {

			int result = count(i, 10);
			if (result == count(i, 12) && result == count(i, 16)) {
				System.out.println(i);
			}
		}
	}

	public static int count(int number, int div) {

		int sum = 0;
		while (number > 0) {
			sum += (number) % div;
			number /= div;
		}
		return sum;
	}
}