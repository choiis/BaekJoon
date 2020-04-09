import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1431 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		Serial[] serials = new Serial[N];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			serials[i] = new Serial(line);
		}

		Arrays.sort(serials);
		for (Serial serial : serials) {
			System.out.println(serial.getStr());
		}
	}
}

class Serial implements Comparable<Serial> {

	private String str;
	private int sum;

	public Serial(String str) {
		super();
		this.str = str;
		sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= 57 && str.charAt(i) >= 48) {
				sum += (str.charAt(i) - 48);
			}
		}
	}

	public String getStr() {
		return str;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public int compareTo(Serial serial) {
		if (str.length() != serial.str.length()) {
			return str.length() - serial.str.length();
		}

		if (sum != serial.sum) {
			return sum - serial.sum;
		} else {
			return str.compareTo(serial.str);
		}
	}

}