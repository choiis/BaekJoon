
import java.util.Scanner;

public class BaekJoon2960 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		boolean ok = false;
		int solution = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j * i <= N; j++) {
				if(!visited[i*j]) {
					visited[i*j] = true;
					cnt++;
					if(cnt==K) {
						solution = i*j;
						ok = true;
					}
				}
				if(ok) {
					break;
				}
			}
			if(ok) {
				break;
			}
		}
		System.out.println(solution);
	}
}