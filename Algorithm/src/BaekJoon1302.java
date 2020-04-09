import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon1302 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			if (map.containsKey(line)) {
				int cnt = map.get(line) + 1;
				map.put(line, cnt);
			} else {
				map.put(line, 1);
			}
		}
		String result = null;
		int resultCnt = 0;
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (resultCnt < map.get(key)) {
				result = key;
				resultCnt = map.get(key);
			} else if (resultCnt == map.get(key)) {
				if (key.compareTo(result) < 0) {
					result = key;
					resultCnt = map.get(key);
				}
			}
		}
		System.out.println(result);
	}
}