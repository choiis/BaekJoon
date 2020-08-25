import java.util.Scanner

fun main(args: Array<String>) {
	var sc: Scanner = Scanner(System.`in`);

	val T: Int = sc.nextInt();
	for (t in 0 until T) {
		val N: Int = sc.nextInt();
		var money: IntArray = IntArray(N);
		for (i in 0 until N) {
			money[i] = sc.nextInt();
		}
		val M: Int = sc.nextInt();
		var coin: IntArray = IntArray(M + 1);
		for (i in 0..M) {
			if (i % money[0] == 0) {
				coin[i]++;
			}
		}

		for (i in 1 until N) {
			for (j in money[i]..M) {
				coin[j] += coin[j - money[i]];
			}
		}
		println(coin[M]);
	}
}