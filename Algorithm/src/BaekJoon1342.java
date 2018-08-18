import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BaekJoon1342 {
	private static Scanner sc = null;

	private static HashSet<String> hset = null;

	private static boolean numberCheck(char[] arr, int length) {
		if (length == 0) {
			return true;
		}

		for (int i = 1; i < length; i++) {
			if (arr[i - 1] == arr[i]) {
				return false;
			}
		}
		return true;
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void perm(char[] arr, int pivot) {
		if (!numberCheck(arr, pivot)) {
			return;
		}

		if (pivot == arr.length) {
			hset.add(new String(arr, 0, pivot));
			return;
		} else {
			for (int i = pivot; i < arr.length; i++) {
				swap(arr, i, pivot);
				perm(arr, pivot + 1);
				swap(arr, i, pivot);
			}
		}

	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		String str = sc.next();

		hset = new HashSet<>();
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		perm(chars, 0);
		System.out.println(hset.size());
	}
}
