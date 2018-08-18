import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon11004 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[K-1]);
	}
}