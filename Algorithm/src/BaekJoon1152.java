import java.util.Scanner;

public class BaekJoon1152 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String allString = sc.nextLine();
		int cnt = 1;
		for (int i = 0; i < allString.length() - 1; i++) {
			if (allString.charAt(i) == ' ') {
				cnt++;
			}
		}
		if (allString.equals("")) {
			cnt = 0;
		}
		if(allString.charAt(0) == ' ') {
			cnt--;
		}
		System.out.println(cnt);
	}
}