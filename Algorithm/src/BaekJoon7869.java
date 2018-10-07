import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon7869 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon7869.txt"));
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double r1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		double r2 = sc.nextDouble();

		double c = dist(x1, y1, x2, y2);

		double cosa = ((r1 * r1) + (c * c) - (r2 * r2)) / (2 * c * r1);
		double cosb = ((r2 * r2) + (c * c) - (r1 * r1)) / (2 * c * r2);

		double theta1 = Math.toDegrees(Math.acos(cosa));
		double theta2 = Math.toDegrees(Math.acos(cosb));

		double s1 = (theta1 * r1 * r1 / 180) * Math.PI;
		double s2 = (theta2 * r2 * r2 / 180) * Math.PI;

		double s = (c + r1 + r2) / 2;
		double S = 2 * Math.sqrt(s * (s - c) * (s - r1) * (s - r2));
		System.out.println((double) Math.round((s1 + s2 - S) * 1000) / (double) 1000.0);
	}

	private static double dist(double x1, double y1, double x2, double y2) {

		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}