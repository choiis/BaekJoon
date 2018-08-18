import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon9252 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon9252.txt"));

		String x = sc.next();
		String y = sc.next();

		int lengthX = x.length();
		int lengthY = y.length();

		int[][] lcs = new int[lengthX + 1][lengthY + 1];
		String[][] lcss = new String[lengthX + 1][lengthY + 1];

		lcss[0][0] = "";
		for (int i = 1; i <= lengthX; i++) {
			lcss[i][0] = "";
		}
		for (int i = 1; i <= lengthY; i++) {
			lcss[0][i] = "";
		}

		for (int i = 1; i <= lengthX; i++) {
			for (int j = 1; j <= lengthY; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					lcss[i][j] = lcss[i - 1][j - 1] + "" + x.charAt(i - 1);
				} else {
					if (lcs[i - 1][j] < lcs[i][j - 1]) {
						lcs[i][j] = lcs[i][j - 1];
						lcss[i][j] = lcss[i][j - 1];
					} else {
						lcs[i][j] = lcs[i - 1][j];
						lcss[i][j] = lcss[i - 1][j];
					}
				}
			}
		}

		System.out.println(lcs[lengthX][lengthY]);
		System.out.println(lcss[lengthX][lengthY]);
	}
}
